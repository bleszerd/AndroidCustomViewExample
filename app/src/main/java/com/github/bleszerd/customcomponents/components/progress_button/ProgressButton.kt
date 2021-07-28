package com.github.bleszerd.customcomponents.components.progress_button

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.github.bleszerd.customcomponents.R
import com.github.bleszerd.customcomponents.databinding.ProgressButtonBinding

/**
CustomComponents
28/07/2021 - 09:56
Created by bleszerd.
@author alive2k@programmer.net
 */
class ProgressButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0,
) :
    FrameLayout(context, attrs, defStyleAttr) {
    private var title: String? = null

    private val binding = ProgressButtonBinding.inflate(LayoutInflater.from(context), this, true)
    private var state: ProgressButtonState = ProgressButtonState.Enabled
        set(value) {
            field = value
            refreshState()
        }

    init {
        setLayout(attrs)
        refreshState()
    }

    private fun setLayout(attrs: AttributeSet?) {
        attrs?.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.ProgressButton
            )

            setBackgroundResource(R.drawable.progress_button_background)

            val titleString = attributes.getString(R.styleable.ProgressButton_title)
            if (!titleString.isNullOrEmpty()) {
                title = titleString
            }

            attributes.recycle()
        }
    }

    private fun refreshState() {
        isEnabled = state.isEnabled
        isClickable = state.isEnabled
        refreshDrawableState()

        binding.textTitle.run {
            isEnabled = state.isEnabled
            isClickable = state.isEnabled
        }

        binding.progressBar.visibility = state.progressVisibility
        binding.textTitle.visibility = state.textVisibility

        binding.textTitle.text = title
    }

    fun setEnable() {
        state = ProgressButtonState.Enabled
    }

    fun setLoading() {
        state = ProgressButtonState.Loading
    }

    sealed class ProgressButtonState(
        val isEnabled: Boolean,
        val progressVisibility: Int,
        val textVisibility: Int,
    ) {
        object Enabled : ProgressButtonState(true, View.GONE, View.VISIBLE)
        object Loading : ProgressButtonState(false, View.VISIBLE, View.GONE)
    }
}
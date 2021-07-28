package com.github.bleszerd.customcomponents.components.swipe_component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.motion.widget.MotionLayout
import com.github.bleszerd.customcomponents.R
import com.github.bleszerd.customcomponents.databinding.SwipeComponentBinding

/**
CustomComponents
28/07/2021 - 15:01
Created by bleszerd.
@author alive2k@programmer.net
 */
class SwipeComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) :
    MotionLayout(context, attrs, defStyleAttr) {
    private val binding = SwipeComponentBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        setLayout(attrs)
    }

    private fun setLayout(attrs: AttributeSet?) {
        attrs?.let { attributeSet ->
            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.SwipeComponent
            )

            //Get attrs

            attributes.recycle()
        }
    }

    fun setAddClickListener(listener: OnClickListener) {
        binding.cardAdd.setOnClickListener(listener)
    }

    fun setDeleteClickListener(listener: OnClickListener) {
        binding.cardDelete.setOnClickListener(listener)
    }

    override fun setTransitionListener(listener: TransitionListener?) {
        binding.root.setTransitionListener(listener)
    }

    override fun addTransitionListener(listener: TransitionListener?) {
        binding.root.addTransitionListener(listener)
    }
}
/*
 * Copyright 2017 Yonghoon Kim
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pickth.postpay.view.dialog

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.InputType
import android.view.Gravity
import android.view.WindowManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import com.pickth.postpay.R
import com.pickth.postpay.extension.convertDpToPixel
import com.pickth.postpay.extension.setBackgroundColorWithRadius
import com.ramotion.fluidslider.FluidSlider
import org.jetbrains.anko.*

/**
 * Created by yonghoon on 2018-04-04
 * Blog   : http://blog.pickth.com
 */
class SavingSettingDialog(context: Context, private var savingValue: Int, private val click:(value: Int) -> Unit): Dialog(context, R.style.AppTheme_NoTitle) {
    private lateinit var mFluidSlider: FluidSlider
    private var tvInput: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
        mFluidSlider = FluidSlider(context).apply {
            startText = "0"
            endText = "100"
            colorBar = ContextCompat.getColor(context, R.color.colorAccent)
            colorBubble = ContextCompat.getColor(context, R.color.colorWhite)
            position = (savingValue * 0.01).toFloat()
            positionListener = {
                pos -> val value = (100 * pos).toInt()
                savingValue = value
                bubbleText = "${value}"
                tvInput?.text = "${value}%"
            }
        }

        setContentView(context.verticalLayout {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            val rootPadding = context.convertDpToPixel(9)
            setPadding(rootPadding,0,rootPadding,0)

            addView(mFluidSlider)

            tvInput = textView(savingValue.toString()) {
                layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT).apply {
                    setMargins(0, context.convertDpToPixel(9), 0, context.convertDpToPixel(0))
                }
                textSize = context.convertDpToPixel(15).toFloat()
                gravity = Gravity.CENTER_HORIZONTAL
            }

            textView(context.getString(R.string.saving_explanation)) {
                layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1f).apply {
                    setMargins(context.convertDpToPixel(30), context.convertDpToPixel(30), context.convertDpToPixel(30), context.convertDpToPixel(30))
                }
                setPadding(context.convertDpToPixel(12), 0, context.convertDpToPixel(12), 0)
                gravity = Gravity.CENTER
            }.setBackgroundColorWithRadius(ContextCompat.getColor(context, R.color.colorWhite), ContextCompat.getColor(context, R.color.colorAccent), context.convertDpToPixel(12))

            button("저장") {
                layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT).apply {
                    setMargins(context.convertDpToPixel(30), 0, context.convertDpToPixel(30), context.convertDpToPixel(30))
                }

                if(Build.VERSION.SDK_INT >= 21) elevation = 0f

                setOnClickListener {
                    click(savingValue)
                    dismiss()
                }
            }.setBackgroundColorWithRadius(ContextCompat.getColor(context, R.color.colorWhite), ContextCompat.getColor(context, R.color.colorAccent), context.convertDpToPixel(12))
        })
    }
}
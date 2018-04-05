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
import android.os.Bundle
import android.text.InputType
import android.view.WindowManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import com.pickth.postpay.R
import org.jetbrains.anko.*

/**
 * Created by yonghoon on 2018-04-04
 * Blog   : http://blog.pickth.com
 */
class SavingSettingDialog(context: Context, private val click:(value: Int) -> Unit): Dialog(context, R.style.AppTheme_NoTitle) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
        setContentView(context.verticalLayout {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            var etInput: EditText? = null
            linearLayout {
                layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
                orientation = LinearLayout.HORIZONTAL
                etInput = editText {
                    layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1f)
                    inputType = InputType.TYPE_CLASS_NUMBER
                }
                textView("원")
            }

            textView("자신이 소비할 금액의 몇 %를 저축할지에 대한 설명이 들어갑니다.") {
                layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 1f)
            }
            button("저장") {
                setOnClickListener {
                    if(!etInput?.text.isNullOrBlank()) {
                        click(etInput!!.text.toString().toInt())
                    }
                    dismiss()
                }
            }
        })
    }
}
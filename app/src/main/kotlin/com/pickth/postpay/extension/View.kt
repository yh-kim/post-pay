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

package com.pickth.postpay.extension

import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.View
import org.jetbrains.anko.backgroundDrawable

/**
 * Created by yonghoon on 2018-04-05
 * Blog   : http://blog.pickth.com
 */

fun View.setBackgroundColorWithRadius(backgroundColor: Int, strokeColor: Int, dpValue: Int) {
    if(Build.VERSION.SDK_INT >= 16) {
        background = GradientDrawable().apply {
            setColor(backgroundColor)
            setStroke(context.convertDpToPixel(1), strokeColor)
            cornerRadius = context.convertDpToPixel(dpValue.toFloat())
        }
    } else {
        backgroundDrawable = GradientDrawable().apply {
            setColor(backgroundColor)
            setStroke(context.convertDpToPixel(1), strokeColor)
            cornerRadius = context.convertDpToPixel(dpValue.toFloat())
        }
    }
}
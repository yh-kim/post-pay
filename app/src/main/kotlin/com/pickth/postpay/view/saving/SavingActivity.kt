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

package com.pickth.postpay.view.saving

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

/**
 * Created by yonghoon on 2018-04-03
 * Blog   : http://blog.pickth.com
 */
class SavingActivity: AppCompatActivity() {
    private lateinit var rvSaving: RecyclerView
    private lateinit var mSavingAdapter: SavingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSavingAdapter = SavingAdapter()
        rvSaving = RecyclerView(this).apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            overScrollMode = View.OVER_SCROLL_NEVER
            isNestedScrollingEnabled = false
            adapter = mSavingAdapter
            layoutManager = LinearLayoutManager(this@SavingActivity, LinearLayoutManager.VERTICAL, false)
        }

        val rootView = verticalLayout {
            gravity = Gravity.CENTER_HORIZONTAL
            textView("15,373원") {
                gravity = Gravity.CENTER_HORIZONTAL
            }
            addView(rvSaving)
        }

        setContentView(rootView)

        for(i in 0..3) {
            mSavingAdapter.addItem(Saving("4/$i", "테스트$i", (i+1)*100))
        }
        mSavingAdapter.notifyDataSetChanged()
    }
}
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
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout.LayoutParams
import com.pickth.postpay.R
import com.pickth.postpay.manager.SavingDataManager
import com.pickth.postpay.utils.LinearSpacingItemDecoration
import kotlinx.android.synthetic.main.base_toolbar.view.*
import kotlinx.android.synthetic.main.header_saving.view.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.verticalLayout

/**
 * Created by yonghoon on 2018-04-03
 * Blog   : http://blog.pickth.com
 */
class SavingActivity: AppCompatActivity() {
    private lateinit var rvSaving: RecyclerView
    private lateinit var mSavingAdapter: SavingAdapter
    val icons = ArrayList<Int>().apply {
        add(R.drawable.ic_category_hamburger)
        add(R.drawable.ic_category_chicken)
        add(R.drawable.ic_category_coffe)
        add(R.drawable.ic_category_meat)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSavingAdapter = SavingAdapter()
        rvSaving = RecyclerView(this).apply {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            backgroundColor = ContextCompat.getColor(context, R.color.colorBackGray)
            overScrollMode = View.OVER_SCROLL_NEVER
            isNestedScrollingEnabled = false
            adapter = mSavingAdapter
            addItemDecoration(LinearSpacingItemDecoration(context, 4, false))
            layoutManager = LinearLayoutManager(this@SavingActivity, LinearLayoutManager.VERTICAL, false)
            recycledViewPool.setMaxRecycledViews(0, 0)
        }


        val rootView = verticalLayout {
            gravity = Gravity.CENTER_HORIZONTAL
            backgroundColor = ContextCompat.getColor(context, R.color.colorBackGray)

            // actionbar
            val baseToolbar = LayoutInflater.from(context)
                    .inflate(R.layout.base_toolbar, this, false)
            baseToolbar.toolbar_base.setTitle("저축 내역")
            addView(baseToolbar)
            setSupportActionBar(baseToolbar.toolbar_base)
            supportActionBar?.run {
                setHomeAsUpIndicator(R.drawable.ic_back)
                setDisplayHomeAsUpEnabled(true)
            }

            // saving
            addView(LayoutInflater.from(applicationContext).inflate(R.layout.header_saving, this, false).apply {
                tv_saving_money.text = SavingDataManager.getSavingMoney(context).toString() + " 원"
            })

            // rv
            addView(rvSaving)
        }

        setContentView(rootView)

        for(i in 0..15) {
            mSavingAdapter.addItem(Saving(icons[i%icons.size],"4/$i", "테스트$i", (i+1)*100))
        }
        mSavingAdapter.notifyDataSetChanged()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
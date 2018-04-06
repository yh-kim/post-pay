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

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pickth.postpay.R
import com.pickth.postpay.extension.convertDpToPixel
import com.pickth.postpay.manager.SavingDataManager
import kotlinx.android.synthetic.main.header_saving.view.*
import kotlinx.android.synthetic.main.item_saving.view.*
import org.jetbrains.anko.backgroundDrawable
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.textColor
import java.util.ArrayList

/**
 * Created by yonghoon on 2018-04-05
 * Blog   : http://blog.pickth.com
 */
class SavingAdapter: RecyclerView.Adapter<SavingAdapter.SavingViewHolder>() {
    companion object {
        val SAVING_HEADER = 99
        val SAVING_ITEM = 100
    }

    val mItems = ArrayList<Saving>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavingViewHolder {
        var rootView: View
        if(viewType == SAVING_HEADER) {
            rootView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.header_saving, parent, false)
        } else {
            rootView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_saving, parent, false)
        }
        return SavingViewHolder(rootView)
    }

    override fun getItemCount(): Int = mItems.size + 1

    override fun onBindViewHolder(holder: SavingViewHolder, position: Int) {
        if(position != 0) {
            holder.onBind(mItems[position-1], position-1)
        } else {
            holder.onBindHeader()
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(position == 0) {
            return SAVING_HEADER
        } else {
            return SAVING_ITEM
        }
    }

    fun addItem(saving: Saving) {
        mItems.add(saving)
    }

    class SavingViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun onBindHeader() {
            with(itemView) {
                tv_saving_percentage.text = SavingDataManager.getSavingPercentage(context).toString() + "%"

                tv_saving_money.text = SavingDataManager.getSavingMoney(context).toString() + "원"
            }
        }

        fun onBind(saving: Saving, position: Int) {
            with(itemView) {
                iv_saving_icon.backgroundResource = saving.image
                saving_date.text = saving.date
                saving_name.text = saving.name
                saving_price.text = "+${saving.price.toString()}"
                if(saving.price >= 1000) {
                    saving_price.run {
                        textColor = ContextCompat.getColor(context, R.color.colorPrimaryAccent)
                        textSize = context.convertDpToPixel(7).toFloat()
                    }
                } else {
                    saving_price.textSize = context.convertDpToPixel(5).toFloat()
                }
            }
        }
    }
}
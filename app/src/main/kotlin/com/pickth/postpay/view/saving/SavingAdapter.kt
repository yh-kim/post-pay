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

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pickth.postpay.R
import kotlinx.android.synthetic.main.item_saving.view.*
import java.util.ArrayList

/**
 * Created by yonghoon on 2018-04-05
 * Blog   : http://blog.pickth.com
 */
class SavingAdapter: RecyclerView.Adapter<SavingAdapter.SavingViewHolder>() {
    val mItems = ArrayList<Saving>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavingViewHolder {
        val rootView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_saving, parent, false)
        return SavingViewHolder(rootView)
    }

    override fun getItemCount(): Int = mItems.size

    override fun onBindViewHolder(holder: SavingViewHolder, position: Int) {
        holder.onBind(mItems[position], position)
    }

    fun addItem(saving: Saving) {
        mItems.add(saving)
    }

    class SavingViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun onBind(saving: Saving, position: Int) {
            with(itemView) {
                saving_date.text = saving.date
                saving_name.text = saving.name
                saving_price.text = saving.price.toString()
            }
        }
    }
}
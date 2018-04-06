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

package com.pickth.postpay.view.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pickth.postpay.R
import kotlinx.android.synthetic.main.item_menu.view.*
import org.jetbrains.anko.backgroundResource
import java.util.*

/**
 * Created by yonghoon on 2018-04-06
 * Blog   : http://blog.pickth.com
 */
class MenuAdapter(private val itemClickListener:(pos: Int) -> Unit) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    private var mIcons = ArrayList<Int>().apply {
        add(R.drawable.ic_menu0)
        add(R.drawable.ic_menu1)
        add(R.drawable.ic_menu2)
        add(R.drawable.ic_menu3)
        add(R.drawable.ic_menu4)
        add(R.drawable.ic_menu5)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder =
            MenuViewHolder(
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.item_menu, parent, false)
            )

    override fun getItemCount() = mIcons.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.onBind(position)
    }

    inner class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun onBind(position: Int) {
            with(itemView) {
                iv_menu_icon.backgroundResource = mIcons[position]
                tv_menu_name.text = context.resources.getStringArray(R.array.menu_name)[position]
                setOnClickListener { itemClickListener(position) }
            }
        }
    }
}
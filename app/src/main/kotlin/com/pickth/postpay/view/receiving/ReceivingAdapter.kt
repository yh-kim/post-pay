package com.pickth.postpay.view.receiving

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pickth.postpay.R
import kotlinx.android.synthetic.main.item_receiving.view.*


class ReceivingAdapter : RecyclerView.Adapter<ReceivingAdapter.ReceivingViewHolder>() {

    val items = ArrayList<Receiving>().apply {
        add(Receiving("수신확인","수신 미완료","-","0건"))
        add(Receiving("간편수신", "최근수신일", "-", "0건"))
        add(Receiving("경조수신", "최근수신일", "-", "0건"))
        add(Receiving("더치페이", "요청 미완료", "", "0건"))
        add(Receiving("더치페이", "송금 미완료", "", "0건"))
        add(Receiving("상품결제", "결제대기", "", "0건"))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceivingViewHolder =
            ReceivingViewHolder(
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.item_receiving, parent, false)
            )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ReceivingViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun addItem(receiving: Receiving) {
        items.add(receiving)
    }

    inner class ReceivingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind(position: Int) {
            with(itemView) {
                txt_item_receiving_count_title.text = items[position].title
                txt_item_receiving_count.text = items[position].count
                txt_item_receiving_date.text = items[position].date
                txt_item_receiving_date_title.text = items[position].subTitle
            }
        }
    }
}
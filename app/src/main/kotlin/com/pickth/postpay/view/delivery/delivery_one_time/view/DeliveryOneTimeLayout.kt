package com.pickth.postpay.view.delivery.delivery_one_time.view

import android.view.View
import com.pickth.postpay.R
import org.jetbrains.anko.*


class DeliveryOneTimeLayout : AnkoComponent<DeliveryOneTimeFragment> {
    override fun createView(ui: AnkoContext<DeliveryOneTimeFragment>): View = ui.apply {
        verticalLayout {

            editText {
                id = R.id.edt_one_time_money
                inputType = android.text.InputType.TYPE_CLASS_NUMBER
                hint = "금액을 입력하세요."
                backgroundResource = R.drawable.round_corner
                textSize = sp(5).toFloat()
                leftPadding = dip(10)
                topPadding = dip(3)
                bottomPadding = dip(3)
            }.lparams(width = matchParent) {
                margin = dip(5)
            }

            editText {
                id = R.id.edt_one_time_receiver
                hint = "받는 사람을 입력하세요."
                backgroundResource = R.drawable.round_corner
                textSize = sp(5).toFloat()
                leftPadding = dip(10)
                topPadding = dip(3)
                bottomPadding = dip(3)
            }.lparams(width = matchParent) {
                margin = dip(5)
            }

            textView {
                id = R.id.txt_one_time_sum
                textAlignment = View.TEXT_ALIGNMENT_CENTER
                padding = dip(10)
            }.lparams(width = matchParent) {
                topMargin = dip(10)
                leftMargin = dip(5)
            }

            val total = textView {
                id = R.id.txt_one_time_total
                textAlignment = View.TEXT_ALIGNMENT_CENTER
                padding = dip(10)
            }.lparams(width = matchParent) {
                leftMargin = dip(5)
            }

            button {
                id = R.id.btn_one_time_payment
                setOnClickListener { _ -> payment(total.text.toString()) }
            }
        }
    }.view

    private fun payment(totalMoney: String) {

    }
}


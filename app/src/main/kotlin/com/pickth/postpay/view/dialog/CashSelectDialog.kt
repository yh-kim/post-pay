package com.pickth.postpay.view.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.pickth.postpay.R
import com.pickth.postpay.view.delivery.listener.DialogListener
import kotlinx.android.synthetic.main.view_select_cash_dailog.*


class CashSelectDialog(context: Context, val value: Int) : Dialog(context) {

    var dialogListener: DialogListener? = null
        set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_select_cash_dailog)

        txt_select_cash_money.text = "송급액 : " + value.toString()
        btn_select_cash_ok.setOnClickListener { _ ->
            dialogListener?.onPostiveClicked(edt_select_cash_one.text.toString(), edt_select_cash_five.text.toString(), edt_select_cash_ten.text.toString(), edt_select_cash_fifty.text.toString())
            dismiss()
        }
        btn_select_cash_cancel.setOnClickListener { _ -> cancel() }
    }


}
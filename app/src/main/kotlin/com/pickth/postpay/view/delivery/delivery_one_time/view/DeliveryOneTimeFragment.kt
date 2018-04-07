package com.pickth.postpay.view.delivery.delivery_one_time.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pickth.postpay.R
import com.pickth.postpay.manager.SavingDataManager
import com.pickth.postpay.manager.SavingNotificationManager
import com.pickth.postpay.view.delivery.listener.DialogListener
import com.pickth.postpay.view.dialog.CashSelectDialog
import com.pickth.postpay.view.dialog.DatePickerFragmentDialog
import kotlinx.android.synthetic.main.fragment_delivery_one_time.*
import org.jetbrains.anko.support.v4.toast


class DeliveryOneTimeFragment : Fragment() {

    companion object {
        fun newInstance(id: String): DeliveryOneTimeFragment {
            val args = Bundle()
            args.putString("key", "value")
            val deliveryOneTimeFragment: DeliveryOneTimeFragment = newInstance()
            deliveryOneTimeFragment.arguments = args
            return deliveryOneTimeFragment
        }

        fun newInstance(): DeliveryOneTimeFragment {
            return DeliveryOneTimeFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        txt_foreign_want_date.setOnClickListener { _ ->
            val dialog = DatePickerFragmentDialog(txt_foreign_want_date)
            dialog.show(activity?.fragmentManager, "dialog")
        }

        txt_foreign_address.setOnClickListener { _ ->

        }

        cb_one_time_div_cash.setOnClickListener {
            val number = edt_foreign_send_money.text.toString().toInt()
            val dialog = CashSelectDialog(activity!!, number)
            dialog.dialogListener = object : DialogListener {
                override fun onPostiveClicked(one: String, five: String, ten: String, fifty: String) {
                    txt_one_time_div_cash_result.text = "1000원 : ${one}, 5000원 : ${five}, 10000원 : ${ten}, 50000원 : ${fifty}"
                }

                override fun onCancelClicked() {

                }
            }
            dialog.show()
        }

        btn_foreign_payment.setOnClickListener { _ ->
            val per = SavingDataManager.getSavingPercentage(activity!!)
            if (edt_foreign_send_money.text.isBlank()) {
                toast("기부할 금액을 입력해주세요")
            } else {
                val sending = Integer.parseInt(edt_foreign_send_money.text.toString())
                var saving = sending * per / 100
                SavingDataManager.setSavingMoney(context!!, SavingDataManager.getSavingMoney(context!!) + saving)
                SavingNotificationManager.sendingNoti(context!!, "추가 저축 금액", saving)
                activity?.finish()
            }
        }


        edt_foreign_send_money.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (edt_foreign_send_money.text.toString() != "") {
                    val value = edt_foreign_send_money.text.toString().toInt()
                    val fees: Int = (value * 0.01).toInt()
                    val totalMoney = value + fees
                    txt_foreign_sum.text = "${value}원 + 수수료 (${fees}원)"
                    txt_foreign_total.text = "총 ${totalMoney}원"
                } else {
                    txt_foreign_sum.text = "0원 + 수수료 (0원)"
                    txt_foreign_total.text = "총 0원"
                }
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_delivery_one_time, container, false)
    }
}
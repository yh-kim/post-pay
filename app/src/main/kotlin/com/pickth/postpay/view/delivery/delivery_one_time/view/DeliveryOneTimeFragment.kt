package com.pickth.postpay.view.delivery.delivery_one_time.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pickth.postpay.R
import com.pickth.postpay.view.dialog.DatePickerFragmentDialog
import kotlinx.android.synthetic.main.fragment_delivery_one_time.*


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
package com.pickth.postpay.view.delivery.delivery_one_time.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.pickth.postpay.R
import kotlinx.android.synthetic.main.fragment_delivery_one_time.*
import com.pickth.postpay.view.main.MainActivity



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

        txt_one_time_want_date.setOnClickListener { _ ->
            Toast.makeText(context, "txt click", Toast.LENGTH_SHORT).show()
        }

        edt_one_time_send_money.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (edt_one_time_send_money.text.toString() != "") {
                    val value = edt_one_time_send_money.text.toString().toInt()
                    val fees = value * 0.01
                    val totalMoney = value + fees
                    txt_one_time_sum.text = "${value}원 + 수수료 (${fees}원)"
                    txt_one_time_total.text = "총 ${totalMoney}원"
                } else {
                    txt_one_time_sum.text = "0원 + 수수료 (0원)"
                    txt_one_time_total.text = "총 0원"
                }
            }

        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_delivery_one_time, container, false)
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = DeliveryOneTimeLayout().createView(AnkoContext.Companion.create(context!!, this))


}
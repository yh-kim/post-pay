package com.pickth.postpay.view.delivery.delivery_one_time.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.pickth.postpay.R
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.find

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

        val sum = find<TextView>(R.id.txt_one_time_sum)
        val money = find<EditText>(R.id.edt_one_time_money)
        val total = find<TextView>(R.id.txt_one_time_total)
        money.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (money.text.toString() != "") {
                    val value = money.text.toString().toInt()
                    val fees = value * 0.01
                    val totalMoney = value + fees
                    sum.text = "${value}원 + 수수료 (${fees}원)"
                    total.text = "총 ${totalMoney}원"
                } else {
                    sum.text = ""
                    total.text = ""
                }
            }
        })
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = DeliveryOneTimeLayout().createView(AnkoContext.Companion.create(context!!, this))


}
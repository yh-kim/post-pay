package com.pickth.postpay.view.delivery.deliivery_foreign.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pickth.postpay.R
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.verticalLayout


class DeliveryForeignFragment : Fragment() {

    val name = "외환"

    companion object {
        fun newInstance(): Fragment {
            return DeliveryForeignFragment()
        }

        fun newInstance(id: String): Fragment {
            val arg = Bundle()
            val deliveryForeignFragment = DeliveryForeignFragment()
            deliveryForeignFragment.arguments = arg
            return deliveryForeignFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_delivery_foreign, container, false)
    }
}
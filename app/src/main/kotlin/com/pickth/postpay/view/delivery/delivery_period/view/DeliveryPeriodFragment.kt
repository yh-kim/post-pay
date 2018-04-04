package com.pickth.postpay.view.delivery.delivery_period.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.verticalLayout


class DeliveryPeriodFragment : Fragment() {
    companion object {
        fun newInstance(): DeliveryPeriodFragment {
            return DeliveryPeriodFragment()
        }

        fun newInstance(id: String): DeliveryPeriodFragment {
            val args = Bundle()
            // if has id
            var deliveryPeriodFragment = newInstance()
            deliveryPeriodFragment.arguments = args
            return deliveryPeriodFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {
            verticalLayout{

            }
        }.view
    }


}
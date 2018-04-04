package com.pickth.postpay.view.delivery.deliveryCash

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DeliveryCashFragment : Fragment() {

    companion object {
        fun newInstance(id: String): DeliveryCashFragment {
            var args: Bundle = Bundle()
            args.putString("key", "value")
            var deliveryCashFragment: DeliveryCashFragment = newInstance()
            deliveryCashFragment.arguments = args
            return deliveryCashFragment
        }

        private fun newInstance(): DeliveryCashFragment {
            return DeliveryCashFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            
        }
    }

}
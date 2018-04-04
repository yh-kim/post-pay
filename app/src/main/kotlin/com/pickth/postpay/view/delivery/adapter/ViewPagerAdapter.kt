package com.pickth.postpay.view.delivery.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.pickth.postpay.view.delivery.deliivery_foreign.view.DeliveryForeignFragment
import com.pickth.postpay.view.delivery.delivery_one_time.view.DeliveryOneTimeFragment
import com.pickth.postpay.view.delivery.delivery_period.view.DeliveryPeriodFragment


class ViewPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    private val fragments: Array<Fragment> = arrayOf(
            DeliveryOneTimeFragment.newInstance(),
            DeliveryPeriodFragment.newInstance(),
            DeliveryForeignFragment.newInstance()
    )

    private val titles: Array<String> = arrayOf(
            "일회",
            "정기",
            "외화"
    )

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = titles[position]
}
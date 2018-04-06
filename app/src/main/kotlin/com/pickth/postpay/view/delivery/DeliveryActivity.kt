/*
 * Copyright 2017 Yonghoon Kim
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pickth.postpay.view.delivery

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pickth.postpay.R
import com.pickth.postpay.view.delivery.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_delivery.*
import kotlinx.android.synthetic.main.base_toolbar.*

/**
 * Created by yonghoon on 2018-04-03
 * Blog   : http://blog.pickth.com
 */
class DeliveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery)
        toolbar_base?.title = "현금배송"
        toolbar_base.setTitleTextColor(resources.getColor(R.color.colorWhite))
        setSupportActionBar(toolbar_base)


        val adapter = ViewPagerAdapter(supportFragmentManager)
        vp_delivery.adapter = adapter

    }
}
package com.pickth.postpay.view.donation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.pickth.postpay.R
import com.pickth.postpay.manager.SavingDataManager
import com.pickth.postpay.manager.SavingNotificationManager
import kotlinx.android.synthetic.main.activity_donation.*
import kotlinx.android.synthetic.main.base_toolbar.*
import org.jetbrains.anko.toast

/**
 * Created by HaEun on 2018-04-06.
 */
class DonationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donation)

        // actionbar
        toolbar_base.setTitle("기부")
        setSupportActionBar(toolbar_base)
        supportActionBar?.run {
            setHomeAsUpIndicator(R.drawable.ic_back)
            setDisplayHomeAsUpEnabled(true)
        }

        btn_sending.setOnClickListener {
            val per = SavingDataManager.getSavingPercentage(this)
            if (edt_sending.text.isBlank()) {
                toast("기부할 금액을 입력해주세요")
            }else {
                val sending = Integer.parseInt(edt_sending.text.toString())
                var saving = sending * per / 100
                SavingDataManager.setSavingMoney(applicationContext, SavingDataManager.getSavingMoney(applicationContext) + saving)
                SavingNotificationManager.sendingNoti(applicationContext, "추가 저축 금액" , saving)
                finish()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
package com.pickth.postpay.view.receiving

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.pickth.postpay.R
import com.pickth.postpay.utils.LinearSpacingItemDecoration
import kotlinx.android.synthetic.main.activity_receiving.*
import kotlinx.android.synthetic.main.base_toolbar.*


class ReceivingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiving)

        toolbar_base.title = "수신현황"
        setSupportActionBar(toolbar_base)
        supportActionBar?.run {
            setHomeAsUpIndicator(R.drawable.ic_back)
            setDisplayHomeAsUpEnabled(true)
        }

        rv_receiving.run {
            adapter = ReceivingAdapter()
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(LinearSpacingItemDecoration(context, 1, false))
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
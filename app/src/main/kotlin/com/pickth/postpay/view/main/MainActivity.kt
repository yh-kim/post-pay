package com.pickth.postpay.view.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pickth.postpay.R
import com.pickth.postpay.view.delivery.DeliveryActivity
import com.pickth.postpay.view.saving.SavingActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), MainContract.View {
    override fun showSetSavingDialog() {
    }

    private lateinit var mPresenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // actionbar
        setSupportActionBar(tb_main)

        mPresenter = MainPresenter()

        btn_start_delivery.setOnClickListener {
            startActivity<DeliveryActivity>()
        }
        btn_start_saving.setOnClickListener {
            startActivity<SavingActivity>()
        }
    }
}

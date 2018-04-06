package com.pickth.postpay.view.main

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.pickth.postpay.R
import com.pickth.postpay.utils.GridSpacingItemDecoration
import com.pickth.postpay.view.delivery.DeliveryActivity
import com.pickth.postpay.view.dialog.SavingSettingDialog
import com.pickth.postpay.view.main.adapter.MenuAdapter
import com.pickth.postpay.view.saving.SavingActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.base_toolbar.*
import kotlinx.android.synthetic.main.view_navigation.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.switch
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var mPresenter: MainContract.Presenter
    private lateinit var mSavingSettingDialog: SavingSettingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // actionbar
        setSupportActionBar(toolbar_base)

        val mDrawerToggle = ActionBarDrawerToggle(this, dl_main, tb_main, R.string.nav_open, R.string.nav_close)
        dl_main.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()

        mPresenter = MainPresenter(this)

        updateUi()
        mSavingSettingDialog = SavingSettingDialog(this, mPresenter.getSavingPercentage(), { mPresenter.setSavingPercentage(it) })

        rv_main_menu.run {
            adapter = MenuAdapter({
                when(it) {
                    5 -> {
                        startActivity<DeliveryActivity>()
                    }
                }
            })
            layoutManager = GridLayoutManager(context, 3)
            addItemDecoration(GridSpacingItemDecoration(context, 3, 1, false))
        }

        cv_start_saving.setOnClickListener {
            startActivity<SavingActivity>()
        }
        iv_saving_setting.setOnClickListener {
            showSavingSettingDialog()
        }
        ll_nav.setOnClickListener {  }
    }

    override fun showSavingSettingDialog() {
        mSavingSettingDialog.show()
    }

    override fun getContext(): Context = applicationContext

    override fun showToast(input: String) {
        toast(input)
    }

    override fun updateUi() {
        tv_main_saving_percentage.text = "${mPresenter.getSavingPercentage()}%"
        tv_main_saving_money.text = "${mPresenter.getSavingMoney()}원"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            android.R.id.home -> {
                dl_main.openDrawer(GravityCompat.START)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {

        if(dl_main.isDrawerOpen(GravityCompat.START)) {
            dl_main.closeDrawer(GravityCompat.START)
            return
        }

        super.onBackPressed()
    }

}

package com.pickth.postpay.utils

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger


/**
 * How to use?
 *
 * in class just use log
 * ex) log("error") // output is "error" through d
 * ex) log(0/0) // output is divide by zero through e
 */
fun log(any : Any) {
    Logger.addLogAdapter(AndroidLogAdapter())

    when(any) {
        is Throwable -> Logger.e(any.message)
        else -> Logger.d(any.toString())
    }
}
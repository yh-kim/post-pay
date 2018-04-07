package com.pickth.postpay.view.delivery.listener

interface DialogListener {
    fun onPostiveClicked(one: String, five: String, ten: String, fifty: String)
    fun onCancelClicked()
}
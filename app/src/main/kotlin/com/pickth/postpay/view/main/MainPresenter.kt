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

package com.pickth.postpay.view.main

import com.pickth.postpay.manager.SavingDataManager

/**
 * Created by yonghoon on 2018-04-03
 * Blog   : http://blog.pickth.com
 */
class MainPresenter(private val mView: MainContract.View): MainContract.Presenter {

    override fun setSavingPercentage(value: Int) {
        SavingDataManager.setSavingPercentage(mView.getContext(), value)
        mView.updateUi()
    }

    override fun getSavingPercentage() = SavingDataManager.getSavingPercentage(mView.getContext())

    override fun setSavingMoney(value: Int) {
        SavingDataManager.setSavingMoney(mView.getContext(), value)
        mView.updateUi()
    }

    override fun getSavingMoney() = SavingDataManager.getSavingMoney(mView.getContext())
}
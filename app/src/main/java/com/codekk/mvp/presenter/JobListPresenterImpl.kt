package com.codekk.mvp.presenter

import com.codekk.JobService
import com.codekk.NetFunc
import com.codekk.mvp.model.JobListModel
import com.codekk.mvp.view.ViewManager
import com.codekk.ui.base.BasePresenterImpl

import io.reactivex.network.RxNetWork


/**
 * by y on 2017/5/18.
 */

class JobListPresenterImpl(view: ViewManager.JobListView) : BasePresenterImpl<ViewManager.JobListView, JobListModel>(view), PresenterManager.JobListPresenter {

    override fun netWorkRequest(page: Int) {
        netWork(RxNetWork
                .observable(JobService::class.java)
                .getJobList(page)
                .map(NetFunc()))
    }

    override fun onNetWorkSuccess(data: JobListModel) {
        if (data.summaryArray.isEmpty()) {
            view?.noMore()
        } else {
            super.onNetWorkSuccess(data)
        }
    }
}

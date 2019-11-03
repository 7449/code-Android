package com.codekk.mvp.presenter

/**
 * by y on 2017/5/23.
 */

interface PresenterManager {

    interface BlogListPresenter {
        fun netWorkRequest(page: Int)
    }

    interface JobListPresenter {
        fun netWorkRequest(page: Int)
    }

    interface OpaListPresenter {
        fun netWorkRequest(page: Int)
    }

    interface OpaSearchPresenter {
        fun netWorkRequest(text: String, page: Int)
    }

    interface OpDetailPresenter {
        fun netWorkRequest(id: String, type: Int)
    }

    interface OpListPresenter {
        fun netWorkRequest(page: Int)
    }

    interface OpSearchPresenter {
        fun netWorkRequest(text: String, page: Int)
    }

    interface RecommendListPresenter {
        fun netWorkRequest(page: Int)
    }

    interface RecommendSearchPresenter {
        fun netWorkRequest(name: String, page: Int)
    }

}

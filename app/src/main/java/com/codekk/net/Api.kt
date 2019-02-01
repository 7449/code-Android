package com.codekk.net


import com.codekk.mvp.model.*
import com.codekk.ui.base.BaseModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * by y on 2017/5/16
 */

object Api {
    const val BASE_API = "http://api.codekk.com/"
    private const val OP_LIST_URL = "op/page/" //获取开源项目
    private const val OP_DETAIL_URL = "op/detail/" //获取单个开源项目 ReadMe
    private const val OP_SEARCH_URL = "op/search" //搜索开源项目
    private const val OPA_LIST_URL = "opa/page/" //获取源码解析文章列表
    private const val OPA_DETAIL_URL = "opa/detail/" //获取单个源码解析文章详情
    private const val OPA_SEARCH_URL = "opa/user/"
    private const val JOB_LIST_URL = "job/page/" //获取职位内推文章列表
    private const val JOB_DETAIL_URL = "job/detail/" //获取单个职位内推文章详情
    private const val BLOG_LIST_URL = "blog/page/" //获取博客文章列表
    private const val BLOG_DETAIL_URL = "blog/detail/" //获取单个博客文章详情
    private const val RECOMMEND_LIST_URL = "recommend/page/" //获取今日推荐列表
    private const val RECOMMEND_SEARCH_URL = "recommend/user/" //根据推荐者查询推荐列表

    interface OpService {
        @GET(Api.OP_LIST_URL + "{page}")
        fun getOpList(@Path("page") page: Int, @Query("type") type: String): Observable<BaseModel<OpListModel>>

        @GET(Api.OP_DETAIL_URL + "{id}" + "/readme")
        fun getOpDetail(@Path("id") id: String): Observable<BaseModel<ReadmeModel>>

        @GET(Api.OP_SEARCH_URL)
        fun getOpSearch(@Query("text") text: String, @Query("page") page: Int): Observable<BaseModel<OpSearchModel>>
    }

    interface OpaService {
        @GET(Api.OPA_LIST_URL + "{page}")
        fun getOpaList(@Path("page") page: Int): Observable<BaseModel<OpaListModel>>

        @GET(Api.OPA_DETAIL_URL + "{id}")
        fun getOpaDetail(@Path("id") id: String): Observable<BaseModel<ReadmeModel>>

        @GET(Api.OPA_SEARCH_URL + "{name}/page/{page}")
        fun getOpaSearch(@Path("name") name: String, @Path("page") page: Int): Observable<BaseModel<OpaSearchModel>>
    }

    interface JobService {
        @GET(Api.JOB_LIST_URL + "{page}")
        fun getJobList(@Path("page") page: Int): Observable<BaseModel<JobListModel>>

        @GET(Api.JOB_DETAIL_URL + "{id}")
        fun getJobDetail(@Path("id") id: String): Observable<BaseModel<ReadmeModel>>
    }

    interface BlogService {
        @GET(Api.BLOG_LIST_URL + "{page}")
        fun getBlogList(@Path("page") page: Int): Observable<BaseModel<BlogListModel>>

        @GET(Api.BLOG_DETAIL_URL + "{id}")
        fun getBlogDetail(@Path("id") id: String): Observable<BaseModel<ReadmeModel>>
    }

    interface RecommendService {
        @GET(Api.RECOMMEND_LIST_URL + "{page}")
        fun getRecommendList(@Path("page") page: Int): Observable<BaseModel<RecommendListModel>>

        @GET(Api.RECOMMEND_SEARCH_URL + "{user}/page/{page}")
        fun getRecommendSearch(@Path("user") name: String, @Path("page") page: Int): Observable<BaseModel<RecommendSearchModel>>
    }
}

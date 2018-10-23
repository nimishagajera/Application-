package com.app.test.app.network

import com.app.test.model.ArticleResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface APIService {

    companion object {
        val BASE_URL = "https://api-mobile.home24.com/api/v1/"
    }

    @GET("articles")
    fun retrieveArticles(@Query("appDomain")appDomain:Int,
                         @Query("locale")locale:String,
                         @Query("limit")limit:Int): Observable<ArticleResponse>
}
package com.app.test.app.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface APIService {

    @GET("“articles")
    fun retrieveArticles(@Path("appDomain")appDomain:String,
                         @Path("locale")locale:String,
                         @Path("limit")limit:Int): Observable<Response<Body>>

    companion object {

        val BASE_URL = "https://api-mobile.home24.com/api/v1/"
    }
}
package com.app.test.app.di.module

import android.content.Context
import android.content.res.Resources
import com.app.test.app.network.APIService
import com.app.test.app.network.exception.GenericException
import com.app.test.util.NetworkUtils
import dagger.Module
import dagger.Provides
import guru.jini.ilf.app.network.exception.InternalServerError
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.SocketException
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton


@Module
class NetworkModule {

    @Inject
    lateinit var apiService: APIService

    /**
     * okhttp method
     */
    @Singleton
    @Provides
    fun getHttpClient(): OkHttpClient.Builder {
        val okHttpClient = OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build()

        return okHttpClient.newBuilder()
    }

    /**
     * getRetrofitBuilder method
     */
    @Singleton
    @Provides
    fun getRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
    }

    /**
     *
     * @param context
     * @param httpClient
     * @param retrofit
     */
    @Singleton
    @Provides
    fun getService(context: Context, httpClient: OkHttpClient.Builder, retrofit: Retrofit.Builder): APIService {
        httpClient.addInterceptor { chain: Interceptor.Chain ->

            if (!NetworkUtils.isNetworkAvailable(context))
                throw GenericException(context, SocketException())

            var originalRequest = chain.request()
            val newRequest: Request.Builder = originalRequest.newBuilder()
            originalRequest = newRequest.build()
            val response = chain.proceed(originalRequest) //perform request, here original request will be executed

            val responseCode = response.code()
            if (responseCode == 500)
                throw GenericException(context, InternalServerError())

            if (responseCode == 404)
                throw GenericException(context, Resources.NotFoundException())

            response
        }

        retrofit
                .baseUrl(APIService.BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()

        return retrofit.build().create<APIService>(APIService::class.java)
    }
}

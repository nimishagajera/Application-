package com.app.test.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import retrofit2.HttpException

class NetworkUtils {

    companion object {
        fun isNetworkAvailable(context: Context): Boolean {
            val connectivityManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo: NetworkInfo = connectivityManager.activeNetworkInfo ?: return false

            return activeNetworkInfo.isAvailable && activeNetworkInfo.isConnected
        }
     }
}
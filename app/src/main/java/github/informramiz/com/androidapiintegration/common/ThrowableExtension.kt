package github.informramiz.com.androidapiintegration.common

import retrofit2.HttpException
import java.net.HttpURLConnection
import java.net.UnknownHostException

/**
 * Created by Ramiz Raja on 2019-07-23
 */
fun Throwable.isNoInternetException() = this is UnknownHostException

fun Throwable?.isUnAuthorizedException(): Boolean {
    this ?: return false
    return this is HttpException && code() == HttpURLConnection.HTTP_UNAUTHORIZED
}

fun Throwable?.toException() = Exception(this ?: Throwable("Unknown error"))
package github.informramiz.com.androidapiintegration.model.repositories.utils

import github.informramiz.com.androidapiintegration.common.isNoInternetException
import github.informramiz.com.androidapiintegration.common.isUnAuthorizedException
import okhttp3.Headers
import retrofit2.HttpException
import retrofit2.Response

/**
 * Created by Ramiz Raja on 2019-07-23
 */
sealed class ApiResponse<T> {
    companion object {
        fun <T> create(throwable: Throwable): ApiErrorResponse<T> {
            return ApiErrorResponse(throwable.message
                ?: "Unknown error", throwable)
        }

        fun <T> create(retrofitResponse: Response<T>): ApiResponse<T> {
            if (retrofitResponse.isSuccessful) {
                val httpCode = retrofitResponse.code()
                val responseBody = retrofitResponse.body()
                return if (httpCode == 204 || responseBody == null) {
                    ApiEmptyResponse(retrofitResponse.headers())
                } else {
                    ApiSuccessResponse(responseBody, retrofitResponse.headers())
                }
            } else {
                val errorBody = retrofitResponse.errorBody()?.string()
                val errorMsg = if (errorBody.isNullOrEmpty()) {
                    retrofitResponse.message()
                } else {
                    errorBody
                }

                return ApiErrorResponse(errorMsg
                    ?: "Unknown error", HttpException(retrofitResponse)
                )
            }
        }
    }
}

//special class to represent empty ApiResponse (body is null or http 204 (no content))
class ApiEmptyResponse<T>(val headers: Headers?) : ApiResponse<T>()

//special class to handle error response
class ApiErrorResponse<T>(
    val errorMessage: String,
    val exception: Throwable? = null) : ApiResponse<T>() {
    fun isNoInternetError(): Boolean {
        return exception?.isNoInternetException() ?: false
    }

    fun isUnAuthorizedError() = exception?.isUnAuthorizedException() ?: false
}

//class to handle successful API response body
class ApiSuccessResponse<T>(val body: T, val headers: Headers?) : ApiResponse<T>()

fun <T> ApiResponse<T>.isSuccess() = this !is ApiErrorResponse
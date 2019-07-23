package github.informramiz.com.androidapiintegration.model.repositories.utils

import com.google.gson.Gson
import github.informramiz.com.androidapiintegration.common.extensions.isJson
import github.informramiz.com.androidapiintegration.model.models.responses.CommonErrorResponse

/**
 * Created by Ramiz Raja on 2019-07-23
 */
data class Resource<out T>(val status: Status,
                           val data: T?,
                           val message: String?,
                           val exception: Throwable? = null) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(data: T?, message: String?, exception: Throwable?): Resource<T> {
            return Resource(Status.ERROR, data, message, exception)
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }

    val parsedErrorMessage: CommonErrorResponse =
        when {
            status == Status.LOADING -> CommonErrorResponse(emptyMap())
            message == null || message.isEmpty() -> CommonErrorResponse(mapOf("en" to "Unknown error"))
            message.isJson() -> Gson().fromJson(message, CommonErrorResponse::class.java)
            else -> CommonErrorResponse(mapOf("en" to message))
        }
}
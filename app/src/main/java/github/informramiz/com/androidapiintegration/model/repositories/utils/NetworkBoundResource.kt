package github.informramiz.com.androidapiintegration.model.repositories.utils

import github.informramiz.com.androidapiintegration.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber
import java.net.UnknownHostException

/**
 * Created by Ramiz Raja on 2019-07-23
 */
abstract class NetworkBoundResource<ApiResponseType>(private val info: CommonInfo) {
    suspend fun start(): Resource<ApiResponseType> {
        return executeApiCall()
    }

    protected open suspend fun executeApiCall(): Resource<ApiResponseType> {
        //make sure our function is main safe
        return withContext(Dispatchers.IO) {
            try {
                val apiResult = createApiCall()
                handleApiResponse(ApiResponse.create(apiResult))
            } catch (unknownHostException: UnknownHostException) {
                getNetworkErrorResource(unknownHostException)
            } catch (e: Exception) {
                Timber.e(e)
                Resource.error(null, e.localizedMessage, e)
            }
        }
    }

    private suspend fun handleApiResponse(apiResponse: ApiResponse<ApiResponseType>): Resource<ApiResponseType> {
        return when (apiResponse) {
            is ApiEmptyResponse -> {
                onEmptyResponse()
                Resource.success(null)
            }
            is ApiErrorResponse -> {
                onFetchFailed()
                getErrorResource(apiResponse)
            }
            else -> { //ApiSuccessResponse
                Resource.success((apiResponse as ApiSuccessResponse).body)
            }
        }
    }

    protected abstract suspend fun createApiCall(): Response<ApiResponseType>

    //-------------utility functions-----------------
    private fun getNetworkErrorResource(unknownHostException: UnknownHostException): Resource<ApiResponseType> {
        return Resource.error(
            null,
            info.context.getString(R.string.error_message_network),
            unknownHostException)
    }

    private fun getErrorResource(apiErrorResponse: ApiErrorResponse<ApiResponseType>): Resource<ApiResponseType> {
        return if (apiErrorResponse.isNoInternetError()) {
            getNetworkErrorResource(UnknownHostException())
        } else {
            Resource.error(null, apiErrorResponse.errorMessage, apiErrorResponse.exception)
        }
    }

    //response handling related functions
    protected open suspend fun onFetchFailed() {}
    protected open suspend fun onEmptyResponse() {}
}
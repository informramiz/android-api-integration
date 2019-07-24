package github.informramiz.com.androidapiintegration.model.repositories.randogrepository

import github.informramiz.com.androidapiintegration.model.models.responses.BreedsListResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Ramiz Raja on 2019-07-23
 */
interface RandogAPI {
    @GET("breeds/list/all")
    suspend fun listBreeds(): Response<BreedsListResponse>
}
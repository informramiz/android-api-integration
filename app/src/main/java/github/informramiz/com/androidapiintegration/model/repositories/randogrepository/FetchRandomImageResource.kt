package github.informramiz.com.androidapiintegration.model.repositories.randogrepository

import github.informramiz.com.androidapiintegration.model.models.responses.BreedRandomImageResponse
import github.informramiz.com.androidapiintegration.model.repositories.utils.CommonInfo
import github.informramiz.com.androidapiintegration.model.repositories.utils.NetworkBoundResource
import retrofit2.Response


/**
 * Created by Ramiz Raja on 2019-07-28.
 */
class FetchRandomImageResource (commonInfo: CommonInfo,
                                private val randomAPI: RandogAPI,
                                private val breedName: String):
    NetworkBoundResource<BreedRandomImageResponse>(commonInfo) {
    override suspend fun createApiCall(): Response<BreedRandomImageResponse> {
        return randomAPI.fetchBreedRandomImage(breedName)
    }
}
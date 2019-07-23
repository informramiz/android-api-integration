package github.informramiz.com.androidapiintegration.model.repositories.randogrepository

import github.informramiz.com.androidapiintegration.model.models.responses.BreedsListResponse
import github.informramiz.com.androidapiintegration.model.repositories.utils.CommonInfo
import github.informramiz.com.androidapiintegration.model.repositories.utils.NetworkBoundResource
import retrofit2.Response

/**
 * Created by Ramiz Raja on 2019-07-23
 */
class ListBreedsNetworkResource(commonInfo: CommonInfo,
                                private val randogAPI: RandogAPI) : NetworkBoundResource<BreedsListResponse>(commonInfo) {
    override suspend fun createApiCall(): Response<BreedsListResponse> {
        return randogAPI.listBreeds()
    }
}
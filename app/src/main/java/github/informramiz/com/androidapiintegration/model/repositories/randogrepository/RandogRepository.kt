package github.informramiz.com.androidapiintegration.model.repositories.randogrepository

import github.informramiz.com.androidapiintegration.model.models.responses.BreedsListResponse
import github.informramiz.com.androidapiintegration.model.repositories.utils.CommonInfo
import github.informramiz.com.androidapiintegration.model.repositories.utils.NetworkBoundResource
import github.informramiz.com.androidapiintegration.model.repositories.utils.Resource
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Ramiz Raja on 2019-07-23
 */
class RandogRepository @Inject constructor(private val commonInfo: CommonInfo,
                                           private val randogAPI: RandogAPI) {
    suspend fun listBreeds(): Resource<BreedsListResponse> {
        return ListBreedsNetworkResource(commonInfo, randogAPI).start()
    }
}
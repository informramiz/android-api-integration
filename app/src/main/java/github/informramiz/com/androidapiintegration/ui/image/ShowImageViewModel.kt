package github.informramiz.com.androidapiintegration.ui.image

import androidx.lifecycle.*
import github.informramiz.com.androidapiintegration.model.repositories.randogrepository.RandogRepository
import github.informramiz.com.androidapiintegration.model.repositories.utils.Resource
import github.informramiz.com.androidapiintegration.ui.base.BaseViewModel
import javax.inject.Inject

class ShowImageViewModel @Inject constructor(
    private val randogRepository: RandogRepository
): BaseViewModel() {
    private val breedName = MutableLiveData<String>()
    private val imageData = breedName.switchMap { breedName ->
        liveData {
            emit(Resource.loading(null))
            emit(randogRepository.fetchRandomImage(breedName))
        }
    }

    fun setBreedName(breedName: String) {
        this.breedName.value = breedName
    }

    fun getImage() = imageData
}

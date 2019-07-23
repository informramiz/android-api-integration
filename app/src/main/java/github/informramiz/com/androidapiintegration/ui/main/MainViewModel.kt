package github.informramiz.com.androidapiintegration.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import github.informramiz.com.androidapiintegration.model.repositories.randogrepository.RandogRepository
import github.informramiz.com.androidapiintegration.model.repositories.utils.Resource
import javax.inject.Inject

class MainViewModel @Inject constructor(private val randogRepository: RandogRepository): ViewModel() {
    private val breedsList = liveData(context = viewModelScope.coroutineContext) {
        emit(Resource.loading(null))
        emit(randogRepository.listBreeds())
    }

    fun getBreedsList() = breedsList
}

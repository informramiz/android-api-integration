package github.informramiz.com.androidapiintegration.ui.image

import github.informramiz.com.androidapiintegration.model.repositories.randogrepository.RandogRepository
import github.informramiz.com.androidapiintegration.ui.base.BaseViewModel
import javax.inject.Inject

class ShowImageViewModel @Inject constructor(
    private val randogRepository: RandogRepository
): BaseViewModel() {

}

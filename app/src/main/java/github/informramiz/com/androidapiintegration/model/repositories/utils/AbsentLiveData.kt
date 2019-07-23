package github.informramiz.com.androidapiintegration.model.repositories.utils

import androidx.lifecycle.LiveData

/**
 * Created by Ramiz Raja on 2019-07-23
 */
class AbsentLiveData<T : Any?> private constructor(): LiveData<T>() {
    init {
        //this can be posted from any thread so using postValue instead of setValue
        postValue(null)
    }

    companion object {
        fun <T> create(): LiveData<T> {
            return AbsentLiveData()
        }
    }
}
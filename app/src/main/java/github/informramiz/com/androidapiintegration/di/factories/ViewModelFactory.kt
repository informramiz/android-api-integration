package github.informramiz.com.androidapiintegration.di.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Ramiz Raja on 2019-06-19
 * Custom view model factory to create injected view models
 */
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        //check if there is any direct class entry in map or any subclass entry
        val creator = creators[modelClass] ?: creators.entries.firstOrNull { entry ->
            //direct entry not found, check for subclass
            modelClass.isAssignableFrom(entry.key)
        }?.value ?: throw IllegalArgumentException("Unknown model class $modelClass")

        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}
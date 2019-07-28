package github.informramiz.com.androidapiintegration.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import github.informramiz.com.androidapiintegration.di.factories.ViewModelFactory
import github.informramiz.com.androidapiintegration.di.keys.ViewModelKey
import github.informramiz.com.androidapiintegration.ui.image.ShowImageViewModel
import github.informramiz.com.androidapiintegration.ui.main.MainViewModel


/**
 * Created by Ramiz Raja on 2019-07-11.
 */
@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShowImageViewModel::class)
    fun bindShowImageViewModel(showImageViewModel: ShowImageViewModel): ViewModel
}
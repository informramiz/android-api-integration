package github.informramiz.com.androidapiintegration.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import github.informramiz.com.androidapiintegration.ui.image.ShowImageFragment
import github.informramiz.com.androidapiintegration.ui.main.MainFragment


/**
 * Created by Ramiz Raja on 2019-07-11.
 */
@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

    @ContributesAndroidInjector
    abstract fun contributeShowImageFragment(): ShowImageFragment
}
package github.informramiz.com.androidapiintegration.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import github.informramiz.com.androidapiintegration.MainActivity


/**
 * Created by Ramiz Raja on 2019-07-11.
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
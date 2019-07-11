package github.informramiz.com.androidapiintegration.di.components

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import github.informramiz.com.androidapiintegration.AppApplication
import github.informramiz.com.androidapiintegration.di.modules.AppModule
import javax.inject.Singleton


/**
 * Created by Ramiz Raja on 2019-07-11.
 */
@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class]
)
interface AppComponent {
    //we are defining custom build to provide it with AppApplication using
    //method `fun application(application: AppApplication): Builder`
    //so that it later can be used for injection in other classes
    @Component.Builder
    interface Builder {
        //bind `AppApplication` instance to injector
        @BindsInstance
        fun application(application: AppApplication): Builder
        fun build(): AppComponent
    }

    fun inject(application: AppApplication)
}
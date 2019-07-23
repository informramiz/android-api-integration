package github.informramiz.com.androidapiintegration.di.modules

import android.content.Context
import app.jirah.parent.di.scopes.ApplicationContext
import dagger.Module
import dagger.Provides
import github.informramiz.com.androidapiintegration.AppApplication
import javax.inject.Singleton


/**
 * Created by Ramiz Raja on 2019-07-11.
 */
@Module
class AppModule {
    @Singleton
    @Provides
    @ApplicationContext
    fun provideApplication(appApplication: AppApplication): Context {
        return appApplication
    }
}
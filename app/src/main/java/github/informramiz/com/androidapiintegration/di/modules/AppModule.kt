package github.informramiz.com.androidapiintegration.di.modules

import app.jirah.parent.di.scopes.ApplicationContext
import dagger.Module
import github.informramiz.com.androidapiintegration.AppApplication


/**
 * Created by Ramiz Raja on 2019-07-11.
 */
@Module
class AppModule {
    @ApplicationContext
    fun provideApplication(appApplication: AppApplication): AppApplication {
        return appApplication
    }
}
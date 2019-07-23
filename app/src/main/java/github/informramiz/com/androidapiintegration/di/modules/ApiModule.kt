package github.informramiz.com.androidapiintegration.di.modules

import app.jirah.parent.di.scopes.ApiInfo
import app.jirah.parent.di.scopes.UnAuthorized
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import github.informramiz.com.androidapiintegration.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * Created by Ramiz Raja on 2019-07-11.
 */
@Module
class ApiModule {
    @Provides
    @Singleton
    @ApiInfo
    fun provideApiBaseLink(): String {
        return BuildConfig.API_BASE_LINK
    }

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        val timeoutTime = 1L //minutes

        okHttpBuilder.readTimeout(timeoutTime, TimeUnit.MINUTES)
        okHttpBuilder.writeTimeout(timeoutTime, TimeUnit.MINUTES)
        okHttpBuilder.connectTimeout(timeoutTime, TimeUnit.MINUTES)

        if (BuildConfig.DEBUG) {
            //add interceptor to print API input/response for debug builds
            okHttpBuilder.addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }
        return okHttpBuilder.build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(@UnAuthorized httpClient: OkHttpClient,
                               gsonConverterFactory: GsonConverterFactory,
                               @ApiInfo apiBaseLink: String): Retrofit.Builder {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(apiBaseLink)
            .addConverterFactory(gsonConverterFactory)
    }
}
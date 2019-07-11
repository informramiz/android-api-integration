package github.informramiz.com.androidapiintegration.di.injector

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.HasFragmentInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import github.informramiz.com.androidapiintegration.AppApplication
import github.informramiz.com.androidapiintegration.di.callbacks.ActivityLifeCycleCallbacksHandler
import github.informramiz.com.androidapiintegration.di.components.DaggerAppComponent

/**
 * Created by Ramiz Raja on 2019-06-18
 */
object AppInjector {
    fun init(application: AppApplication) {
        //inject into AppApplication
        DaggerAppComponent
            .builder()
            .application(application)
            .build()
            .inject(application)

        application.registerActivityLifecycleCallbacks(object : ActivityLifeCycleCallbacksHandler() {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivityInjection(activity)
                handleFragmentInjection(activity)
            }
        })
    }

    private fun handleActivityInjection(activity: Activity) {
        //if activity has marked itself injectable or it has an injector
        //that needs to be used to inject its fragments then inject the activity
        if (activity is Injectable
            || activity is HasFragmentInjector
            || activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }
    }

    private fun handleFragmentInjection(activity: Activity) {
        //for each fragment attached to this activity, if that fragment has marked
        //itself as injectable then inject that fragment
        if (activity is AppCompatActivity) {
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
                object : FragmentManager.FragmentLifecycleCallbacks() {
                    override fun onFragmentAttached(fm: FragmentManager, fragment: Fragment, context: Context) {
                        if (fragment is Injectable) {
                            AndroidSupportInjection.inject(fragment)
                        }
                        super.onFragmentAttached(fm, fragment, context)
                    }
                }, true)
        }
    }
}
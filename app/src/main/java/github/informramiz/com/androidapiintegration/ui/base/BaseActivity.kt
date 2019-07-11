package github.informramiz.com.androidapiintegration.ui.base

import android.annotation.SuppressLint
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import github.informramiz.com.androidapiintegration.di.injector.Injectable
import javax.inject.Inject


/**
 * Created by Ramiz Raja on 2019-07-11.
 */
@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector, Injectable {
    @Inject
    protected lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    protected lateinit var baseViewModelFactory: ViewModelProvider.Factory

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    protected inline fun <reified VM: ViewModel> appViewModels(): Lazy<VM> {
        return viewModels { baseViewModelFactory }
    }
}
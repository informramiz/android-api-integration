package github.informramiz.com.androidapiintegration.ui.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
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
open class BaseFragment : Fragment(), Injectable, HasSupportFragmentInjector {
    @Inject
    protected lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    protected lateinit var baseViewModelFactory: ViewModelProvider.Factory

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    protected inline fun <reified VM: ViewModel> appViewModels(): Lazy<VM> {
        return viewModels { baseViewModelFactory }
    }

    protected inline fun <reified VM: ViewModel> appActivityViewModels(): Lazy<VM> {
        return activityViewModels { baseViewModelFactory }
    }
}
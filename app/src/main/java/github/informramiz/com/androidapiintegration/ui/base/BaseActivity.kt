package github.informramiz.com.androidapiintegration.ui.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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
class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector, Injectable {
    @Inject
    private lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    protected lateinit var baseViewModelFactory: ViewModelProvider.Factory

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }
}
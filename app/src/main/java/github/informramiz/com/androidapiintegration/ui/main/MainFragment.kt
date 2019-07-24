package github.informramiz.com.androidapiintegration.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import github.informramiz.com.androidapiintegration.R
import github.informramiz.com.androidapiintegration.model.repositories.utils.Status
import github.informramiz.com.androidapiintegration.ui.base.BaseFragment
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.progress_bar_view.*
import timber.log.Timber

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by appViewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        registerObservers()
    }

    private fun registerObservers() {
        viewModel.getBreedsList().observe(viewLifecycleOwner, Observer { resource ->
            progress_bar.isVisible = resource.status == Status.LOADING
            Timber.d(resource.data.toString())
            text_view_breeds_list.text = resource.data?.breedsNames?.joinToString(", ")
        })
    }
}

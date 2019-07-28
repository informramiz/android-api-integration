package github.informramiz.com.androidapiintegration.ui.image

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import github.informramiz.com.androidapiintegration.R
import github.informramiz.com.androidapiintegration.ui.base.BaseFragment

class ShowImageFragment : BaseFragment() {

    companion object {
        fun newInstance() = ShowImageFragment()
    }

    private val viewModel by appViewModels<ShowImageViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.show_image_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}

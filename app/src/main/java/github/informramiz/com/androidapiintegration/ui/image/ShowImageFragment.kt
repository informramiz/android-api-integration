package github.informramiz.com.androidapiintegration.ui.image

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import github.informramiz.com.androidapiintegration.R
import github.informramiz.com.androidapiintegration.ui.base.BaseFragment
import github.informramiz.com.androidapiintegration.ui.base.extensions.handleResource
import github.informramiz.com.androidapiintegration.ui.base.extensions.loadImage
import kotlinx.android.synthetic.main.progress_bar_view.*
import kotlinx.android.synthetic.main.show_image_fragment.*

class ShowImageFragment : BaseFragment() {

    companion object {
        fun newInstance() = ShowImageFragment()
    }

    private val viewModel by appViewModels<ShowImageViewModel>()
    private val navArgs by navArgs<ShowImageFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setBreedName(navArgs.breedName)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.show_image_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        registerObservers()
    }

    private fun registerObservers() {
        viewModel.getImage().observe(viewLifecycleOwner, Observer { resource ->
            handleResource(resource, null) { imageData ->
                image_view.loadImage(imageData?.imageUrl)
            }
        })
    }
}

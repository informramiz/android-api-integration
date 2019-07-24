package github.informramiz.com.androidapiintegration.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import github.informramiz.com.androidapiintegration.R
import github.informramiz.com.androidapiintegration.model.repositories.utils.Status
import github.informramiz.com.androidapiintegration.ui.base.BaseFragment
import github.informramiz.com.androidapiintegration.ui.base.extensions.handleResource
import github.informramiz.com.androidapiintegration.ui.main.breedslist.BreedsRecyclerAdapter
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.progress_bar_view.*
import timber.log.Timber

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by appViewModels<MainViewModel>()
    private val recyclerAdapter = BreedsRecyclerAdapter { breedName ->
        //TODO
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        registerObservers()
    }

    private fun setupRecyclerView() {
        recycler_view_breed_names.apply {
            adapter = recyclerAdapter
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            setHasFixedSize(true)
        }
    }

    private fun registerObservers() {
        viewModel.getBreedsList().observe(viewLifecycleOwner, Observer { resource ->
            handleResource(resource, progress_bar) {
                resource.data ?: return@handleResource
                recyclerAdapter.submitList(resource.data.breedsNames)

            }
        })
    }
}

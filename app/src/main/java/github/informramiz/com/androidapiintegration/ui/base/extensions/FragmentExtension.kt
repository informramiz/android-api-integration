package github.informramiz.com.androidapiintegration.ui.base.extensions

import android.app.Activity
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import github.informramiz.com.androidapiintegration.model.repositories.utils.Resource

/**
 * Created by Ramiz Raja on 2019-07-24
 */
fun <T> Fragment.handleResource(resource: Resource<T>,
                                progressBar: ProgressBar?,
                                codeBlock: (T?) -> Unit) {
    requireActivity().handleResource(resource, progressBar, codeBlock, null)
}
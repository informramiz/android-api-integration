package github.informramiz.com.androidapiintegration.ui.base.extensions

import android.app.Activity
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import github.informramiz.com.androidapiintegration.model.repositories.utils.Resource
import github.informramiz.com.androidapiintegration.model.repositories.utils.Status

/**
 * Created by Ramiz Raja on 2019-07-24
 */
fun <T> Activity.handleResource(resource: Resource<T>,
                                progressBar: ProgressBar?,
                                codeBlock: (T?) -> Unit,
                                errorBlock: (() -> Unit)? = null) {
    progressBar?.isVisible = resource.status == Status.LOADING
    when (resource.status) {
        Status.SUCCESS -> codeBlock.invoke(resource.data)
        Status.ERROR -> {
            errorBlock?.invoke()
                ?: Toast.makeText(this, resource.parsedErrorMessage.localizedMessage, Toast.LENGTH_SHORT)
                    .show()
        }
        Status.LOADING -> {}
    }
}

fun <T> Activity.handleResource(resource: Resource<T>,
                                progressBar: ProgressBar?,
                                codeBlock: (T?) -> Unit) = handleResource(resource, progressBar, codeBlock, null)
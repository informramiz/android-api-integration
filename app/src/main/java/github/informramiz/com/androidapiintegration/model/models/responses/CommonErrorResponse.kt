package github.informramiz.com.androidapiintegration.model.models.responses

import github.informramiz.com.androidapiintegration.common.extensions.LocalizedString
import github.informramiz.com.androidapiintegration.common.extensions.localizedText

/**
 * Created by Ramiz Raja on 2019-07-23
 */
data class CommonErrorResponse(val errorMessage: LocalizedString) {
    val localizedMessage: String
        get() = errorMessage.localizedText()
}
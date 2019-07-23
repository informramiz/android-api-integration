package github.informramiz.com.androidapiintegration.model.models.responses

/**
 * Created by Ramiz Raja on 2019-07-23
 */
data class BreedsListResponse(val message: Map<String, Array<String>> = emptyMap()) {
    val breedsNames: List<String>
        get() {
            return message.keys.toList()
        }
}
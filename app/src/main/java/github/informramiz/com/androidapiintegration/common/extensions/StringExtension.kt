package github.informramiz.com.androidapiintegration.common.extensions

import android.text.Editable
import android.text.SpannableStringBuilder
import org.json.JSONObject

/**
 * Created by Ramiz Raja on 2019-07-23
 */
fun String.isJson(): Boolean {
    return try {
        JSONObject(this)
        true
    } catch (e: Exception) {
        false
    }
}

fun String?.editable(): Editable? {
    return this?.let { SpannableStringBuilder(this) }
}
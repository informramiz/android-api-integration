package github.informramiz.com.androidapiintegration.common.extensions

import android.text.Editable
import android.text.SpannableStringBuilder
import androidx.recyclerview.widget.DiffUtil
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

val String.Companion.STRING_DIFF_CALLBACK : DiffUtil.ItemCallback<String>
    get() = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
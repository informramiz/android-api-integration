package github.informramiz.com.androidapiintegration.common.extensions

import java.util.*

/**
 * Created by Ramiz Raja on 2019-07-23
 */
typealias LocalizedString = Map<String, String>

fun Map<String, String>?.en(): String? {
    return this?.let { this["en"] }
}

fun Map<String, String>?.ar(): String? {
    return this?.let { this["ar"] }
}

fun Map<String, String>?.localizedText(): String {
    if (this == null || isEmpty()) {
        return ""
    }

    //if there is an english translation then use that as default otherwise get first
    //value to user
    val defaultValue = (if (this.containsKey("en")) this["en"] else this.values.first()) ?: ""
    if (count() == 1) {
        return defaultValue
    }

    val currentLocale = Locale.getDefault()
    return this.entries.firstOrNull { (key, _) ->
        currentLocale.language == key
    }?.value ?: defaultValue
}
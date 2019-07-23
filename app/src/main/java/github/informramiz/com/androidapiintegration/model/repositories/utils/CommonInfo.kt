package github.informramiz.com.androidapiintegration.model.repositories.utils

import android.content.Context
import app.jirah.parent.di.scopes.ApplicationContext
import javax.inject.Inject

/**
 * Created by Ramiz Raja on 2019-07-23
 */
data class CommonInfo @Inject constructor(@ApplicationContext val context: Context)
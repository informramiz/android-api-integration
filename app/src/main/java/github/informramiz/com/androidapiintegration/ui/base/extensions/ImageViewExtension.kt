package github.informramiz.com.androidapiintegration.ui.base.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso
import github.informramiz.com.androidapiintegration.R


/**
 * Created by Ramiz Raja on 2019-07-28.
 */
fun ImageView.loadImage(url: String?) {
    Picasso.get()
        .load(url)
        .error(R.drawable.ic_launcher_foreground)
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(this)
}
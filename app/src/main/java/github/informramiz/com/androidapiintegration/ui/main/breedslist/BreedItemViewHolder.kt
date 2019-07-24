package github.informramiz.com.androidapiintegration.ui.main.breedslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import github.informramiz.com.androidapiintegration.R

/**
 * Created by Ramiz Raja on 2019-07-24
 */
class BreedItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val nameTextView = itemView as TextView

    fun bind(breedName: String) {
        nameTextView.text = breedName
    }

    companion object {
        fun create(parent: ViewGroup): BreedItemViewHolder {
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_breed_name, parent, false).also {
                return BreedItemViewHolder(it)
            }
        }
    }
}
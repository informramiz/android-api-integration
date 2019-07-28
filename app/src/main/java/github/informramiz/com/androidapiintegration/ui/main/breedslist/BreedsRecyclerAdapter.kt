package github.informramiz.com.androidapiintegration.ui.main.breedslist

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import github.informramiz.com.androidapiintegration.common.extensions.STRING_DIFF_CALLBACK

/**
 * Created by Ramiz Raja on 2019-07-24
 */
class BreedsRecyclerAdapter(private val callback: ((String) -> Unit)? = null)
    : ListAdapter<String, BreedItemViewHolder>(String.STRING_DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedItemViewHolder {
        return BreedItemViewHolder.create(parent).apply {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    callback?.invoke(getItem(adapterPosition))
                }
            }
        }
    }

    override fun onBindViewHolder(holder: BreedItemViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }
}
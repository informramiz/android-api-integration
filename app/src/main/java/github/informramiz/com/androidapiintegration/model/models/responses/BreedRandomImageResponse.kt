package github.informramiz.com.androidapiintegration.model.models.responses

import com.google.gson.annotations.SerializedName

/**
 * Created by Ramiz Raja on 2019-07-24
 */
data class BreedRandomImageResponse(val status: String,
                                    @field:SerializedName("message")
                                    val imageUrl: String)
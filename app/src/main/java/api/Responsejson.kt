package api

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Responsejson(

	@field:SerializedName("Responsejson")
	val responsejson: List<ResponsejsonItem>? = null
) : Parcelable

@Parcelize
data class ResponsejsonItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
) : Parcelable

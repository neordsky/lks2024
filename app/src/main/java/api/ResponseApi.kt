package api

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class ResponseApi(

	@field:SerializedName("per_page")
	val perPage: Int? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("support")
	val support: Support? = null
) : Parcelable

@Parcelize
data class ResponseUser(
	@field:SerializedName("data")
	val data: List<DataItem>? = null,
	@field:SerializedName("support")
	val support: Support? = null

):Parcelable

@Parcelize
data class ResponseUpdate(
	@field:SerializedName("name")
	val name: String? = null,
	@field:SerializedName("job")
	val job: String? = null,
	@field:SerializedName("id")
	val id: Int? = null,

): Parcelable
@Parcelize
data class ResponseRegister(
	@field:SerializedName("status")
	val status: String? = null,
	@field:SerializedName("message")
	val message: String? = null,
	@field:SerializedName("data")
	val data: String? = null,


	): Parcelable



	@Parcelize
data class ResponsesDelete(
	@field:SerializedName("data")
	val data: List<DataItem?>? = null,
): Parcelable


@Parcelize
data class Support(

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable

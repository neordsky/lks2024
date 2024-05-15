package api

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface{
    @GET("api/")
    fun Get(): Call<ResponseApi>

    @GET("api/products")
    @Headers("Accept:applicaiton/json","Content-Type:application/json","Authorization: Bearer {token}")
    fun getprodutc(token: String?): Response<ResponseProduct>

    @POST("login")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun pos(@Body params: LoginRequest ): Call<ResponseLogin>

    @PATCH("api/users/{id}")
    fun patc(@Path("id") id: String,@Body params: RequestBody): Call<ResponseUpdate>

    @DELETE("api/users/{id}")
    fun delda(@Path("id") id: String,@Body params: RequestBody): Call<ResponsesDelete>

    @POST("api/register")
    @Headers("Accept:application/json")
    fun login(@Body params: RequestBody): Call<ResponseLogin>

    @GET("api/users/{id}")
    fun user(@Path("id") id: Int?): Call<ResponseUser>

}
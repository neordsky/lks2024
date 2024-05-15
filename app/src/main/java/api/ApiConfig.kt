package api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class ApiConfig {
    companion object {
        val loggi = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val okhtp = OkHttpClient.Builder()
            .connectTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .readTimeout(30,TimeUnit.SECONDS)
            .addInterceptor(loggi)
            .build()
        const val baseurl = "http://103.187.147.96/api/"

        fun getApiService(): ApiInterface{
            val retro = Retrofit.Builder()

                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retro.create(ApiInterface::class.java)
        }
    }
}
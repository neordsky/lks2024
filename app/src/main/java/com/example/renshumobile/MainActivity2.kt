package com.example.renshumobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import api.ApiConfig
import api.ResponseLogin
import api.ResponseRegister
import api.ResponseUpdate
import com.example.renshumobile.databinding.ActivityMain2Binding
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Header

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.logbut.setOnClickListener {
//            val jsobje = JSONObject()
//            jsobje.put("name",binding.UserText.text)
//            jsobje.put("username",binding.UserText.text)
//            jsobje.put("password",binding.Passw.text)
//            jsobje.put("password_confirmation", binding.Passw.text)
//            jsobje.put("address",binding.alam.text)
//
//            val jsobjstr = jsobje.toString()
//            val reqbod = jsobjstr.toRequestBody("application/json".toMediaTypeOrNull())
//
//            val client = ApiConfig.getApiService().pos(reqbod)
//            client.enqueue(object : Callback<ResponseLogin>{
//                override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
//                    Toast.makeText(applicationContext,"errorr",Toast.LENGTH_LONG).show()
//                    Log.e("error",t.message!!)
//                }
//
//                override fun onResponse(
//                    call: Call<ResponseLogin>,
//                    response: Response<ResponseLogin>
//                ) {
//
//                    Toast.makeText(applicationContext,jsobjstr,Toast.LENGTH_LONG).show()
//                    finish()
//
//                }
//            })
//
//        }
        binding.cretbut.setOnClickListener {
            finish()
        }
    }

}
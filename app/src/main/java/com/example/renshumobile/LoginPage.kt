package com.example.renshumobile

import Navigasion.NaviagasionForm
import UserData.Model
import UserData.UserSharedPrefences
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Display.Mode
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import api.ApiConfig
import api.LoginRequest
import api.ResponseLogin
import api.ResponseRegister
import api.ResponseUpdate
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPage : AppCompatActivity() {
    companion object {
        const val UserVal = "kuhaku"
        const val PassVal = "kuuhaku"
    }

    private lateinit var Sshre: Model
    private lateinit var judul : TextView
    private lateinit var logbut : Button
    private lateinit var crea : Button
    private lateinit var userbox: EditText
    private lateinit var passbox: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        judul = findViewById(R.id.textjud)
        logbut = findViewById(R.id.btn_login)
        crea =findViewById(R.id.cretbut)
        userbox =findViewById(R.id.UserText)
        passbox = findViewById(R.id.Passw)

        judul.text = "Athentication"
        val userpref = UserSharedPrefences(this)

        logbut.setOnClickListener {
           if (userbox.text.isEmpty() || passbox.text.isEmpty()){
               Toast.makeText(applicationContext,"Data Must Full on,",Toast.LENGTH_LONG).show()
           }
            else{
                var loginRequest = LoginRequest(userbox.text.toString(),passbox.text.toString())
                val client = ApiConfig.getApiService().pos(loginRequest)
                client.enqueue(object : Callback<ResponseLogin>{
                   override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {

                       Toast.makeText(applicationContext,t.message.toString(),Toast.LENGTH_LONG).show()
                   }

                   override fun onResponse(
                       call: Call<ResponseLogin>,
                       response: Response<ResponseLogin>
                   ) {

                       println(response.code())
                       println(response.errorBody())
                       println(response.message())

                       if (response.body() != null){
                               val ref = UserSharedPrefences(this@LoginPage)
                               ref.setUser(Model(response.body()?.data))
                               Log.e("message",ref.getuser()?.data.toString())


                               val desti = Intent(this@LoginPage,NaviagasionForm::class.java)
                               startActivity(desti)
                               Toast.makeText(applicationContext,"Data",Toast.LENGTH_LONG).show()

                           }else{
                               Toast.makeText(applicationContext,"Data is Empty",Toast.LENGTH_LONG).show()
                           }





                   }
                })

               val userna = userbox.text.toString()
               val pws = passbox.text.toString()

           }


        }
        crea.setOnClickListener {
            val desti = Intent(this,MainActivity2::class.java)
            startActivity(desti)
        }


    }
}
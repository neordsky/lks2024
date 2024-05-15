package com.example.renshumobile

import Adapter.PencarianAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import api.ApiConfig
import api.ResponseApi
import api.ResponseUser
import com.example.renshumobile.databinding.ActivitySearchPageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchPage : AppCompatActivity() {

    private lateinit var binding: ActivitySearchPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.wadasaga.hasFixedSize()
        binding.wadasaga.layoutManager = GridLayoutManager(this,2)
        binding.bagk.setOnClickListener {
            finish()
        }
        val Tex = binding.serc.text.toString()
        val numid = Tex.toInt()

        val client = ApiConfig.getApiService().user(numid)
        client.enqueue(object : Callback<ResponseUser> {
            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Toast.makeText(applicationContext,"Errorr", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if (response.body() === null){
                    Toast.makeText(applicationContext,"Data is Empty", Toast.LENGTH_LONG).show()
                }
                else{
                    val resda = response.body()?.data
                    binding.wadasaga.adapter = PencarianAdapter(ArrayList(resda))

                }
            }
        })
    }
}
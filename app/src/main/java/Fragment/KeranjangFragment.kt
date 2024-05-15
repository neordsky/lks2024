package Fragment

import Adapter.KeranjangAdapter
import Model.ModelBarang
import Model.Model_User
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import api.ApiConfig
import api.ResponseApi
import api.Responsejson
import api.ResponsejsonItem
import com.example.renshumobile.databinding.FragmentKeranjangBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class KeranjangFragment : Fragment() {

    private lateinit var binding: FragmentKeranjangBinding
    private val lisda = ArrayList<ModelBarang>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKeranjangBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.wadakera.setHasFixedSize(true)
        binding.wadakera.layoutManager = LinearLayoutManager(requireContext())
        loaddata(view)





    }
    private fun loaddata(view:View){
        val client = ApiConfig.getApiService().Get()
        client.enqueue(object : Callback<ResponseApi> {
            override fun onFailure(call: Call<ResponseApi>, t: Throwable) {
                Log.e("errorr",t.message!!)
            }

            override fun onResponse(call: Call<ResponseApi>, response: Response<ResponseApi>) {
                if (response.body() === null){
                    Log.e("error","data is empty")

                }
                else{

                    val resda = response.body()?.data
                    val adapt = KeranjangAdapter(ArrayList(resda))



                     binding.wadakera.adapter = adapt
                }
            }
        }

        )}



}
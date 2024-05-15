package Fragment

import Adapter.PencarianAdapter
import Model.Model_User
import UserData.UserSharedPrefences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import api.ApiConfig
import api.ResponseApi
import api.ResponseProduct
import com.example.renshumobile.BarangAdapter
import com.example.renshumobile.R
import com.example.renshumobile.databinding.FragmentBarafragBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class Barafrag : Fragment() {

    private lateinit var binding: FragmentBarafragBinding
    private val lisda = ArrayList<Model_User>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBarafragBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recx.hasFixedSize()
        binding.recx.layoutManager = GridLayoutManager(requireContext(),2)
        val preef = UserSharedPrefences(requireContext())
       val gtu= preef.getuser()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val resp = ApiConfig.getApiService().getprodutc(gtu.data)
                if (resp.body() != null){
                    binding.recx.adapter = PencarianAdapter(ArrayList(resp.body()?.data))
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
//        val client = ApiConfig.getApiService().getprodutc(gtu.data).en,object : Callback<ResponseProduct>{
//            override fun onFailure(call: Call<ResponseProduct>, t: Throwable) {
//                Toast.makeText(requireContext(),"Errorr",Toast.LENGTH_LONG).show()
//            }
//
//            override fun onResponse(call: Call<ResponseProduct>, response: Response<ResponseProduct>) {
//                if (response.body() === null){
//                    Toast.makeText(requireContext(),"Data is Empty",Toast.LENGTH_LONG).show()
//                }
//                else{
//                    val resda = response.body()?.data
//                    binding.recx.adapter = PencarianAdapter(ArrayList(resda))
//
//                }
//            }
//        })
    }


}
package Fragment

import Adapter.KeranjangAdapter
import Adapter.PencarianAdapter
import Model.ModelBarang
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.renshumobile.BarangAdapter
import Model.Model_User
import UserData.UserSharedPrefences
import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import api.ApiConfig
import api.ResponseApi
import com.example.renshumobile.databinding.FragmentBarangBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


class BarangFragment : Fragment() {
   private lateinit var binding: FragmentBarangBinding
    private lateinit var rcdata: RecyclerView
    private val lisda = ArrayList<Model_User>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBarangBinding.inflate(inflater,container,false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.reci.setHasFixedSize(true)
        binding.reci.layoutManager = GridLayoutManager(requireContext(),2)
        val preef = UserSharedPrefences(requireContext())
        val gtu= preef.getuser()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val resp = ApiConfig.getApiService().getprodutc(gtu.data)
                if (resp.body() != null){
                    binding.reci.adapter = BarangAdapter(requireContext(),ArrayList(resp.body()?.data))
                }
            }catch (e: Exception){
                e.printStackTrace()
            }
        }

    }



}
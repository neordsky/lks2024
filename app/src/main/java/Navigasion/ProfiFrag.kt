package Navigasion

import Fragment.BarangFragment
import UserData.Model
import UserData.UserSharedPrefences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import api.ApiConfig
import api.ResponseUser
import com.example.renshumobile.R
import com.example.renshumobile.databinding.FragmentProfiBinding
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfiFrag : Fragment() {
     private lateinit var binding:FragmentProfiBinding
     private lateinit var sha:Model
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfiBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tena.text = "Visitory"
        val teno = UserSharedPrefences(requireContext())
        val tarn = teno.getuser()

        val jsob = JSONObject()
        val jsobstr = jsob.toString()
        val jsobreb = jsobstr.toRequestBody("application/json".toMediaTypeOrNull())
        val ki = tarn.data



        binding.logutbut.setOnClickListener {
            val fm = parentFragmentManager
            val fg = BarangFragment()
            val ft = fm.beginTransaction()
            ft.replace(R.id.wadasa,fg)
            ft.addToBackStack(null)
            ft.commit()
        }


    }


}
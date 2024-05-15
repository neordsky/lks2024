package Navigasion

import Adapter.KeranjangAdapter
import Fragment.Barafrag
import Fragment.BarangFragment
import Fragment.KeranjangFragment
import Model.ModelBarang
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import api.ApiConfig
import api.ResponseApi
import api.Responsejson
import com.example.renshumobile.BarangAdapter
import com.example.renshumobile.R
import com.example.renshumobile.SearchPage
import com.example.renshumobile.databinding.FragmentHome2Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFrag : Fragment() {

    private lateinit var binding:FragmentHome2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHome2Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.kebut.setOnClickListener {
            val fm = childFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.haka,KeranjangFragment())
            ft.commit()
//


        }

        binding.babut.setOnClickListener {
            val fm = childFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.haka,Barafrag())
            ft.commit()

        }

        binding.sagatext.setOnClickListener {
           val desti = Intent(requireContext(),SearchPage::class.java)
            startActivity(desti)
        }
    }


}
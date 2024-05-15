package Navigasion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.renshumobile.R
import com.example.renshumobile.databinding.ActivityNaviagasionFormBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class NaviagasionForm : AppCompatActivity() {
    private lateinit var binding: ActivityNaviagasionFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviagasionFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botnavgasi.setOnItemSelectedListener{ MenuItem ->
            when(MenuItem.itemId){
                   R.id.navigahomeche -> {
                       replag(HomeFrag())
                       true
                   }
                R.id.navigaprofche -> {
                    replag(ProfiFrag())
                    true
                }
                else -> false

        } }
        replag(HomeFrag())


    }
    private fun replag(fragment: Fragment){
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.FramLay,fragment)
        ft.commit()
    }
}
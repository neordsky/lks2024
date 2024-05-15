package Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.renshumobile.R
import com.example.renshumobile.databinding.FragmentDialogBinding


class DialogFrag : DialogFragment() {
    private lateinit var binding: FragmentDialogBinding
    private var dialoglist: DiaLisn? = null
    companion object {
        private val Naba = "kkj"
        private val Haba = "98878"
        private val quan = "98"
        private val imgb = "kj"

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDialogBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.Nabadet.text = Naba
        binding.Habadet.text = Haba
        binding.quandet.text = quan

        Glide.with(view).load(imgb).into(binding.imgbarde)

        binding.clo.setOnClickListener {
            dialog?.dismiss()
        }
        binding.adker.setOnClickListener {
            dialoglist?.onsubmit(binding.Nabadet.text.toString(),binding.Habadet.toString(),binding.quandet.toString())
            dialog?.dismiss()
        }

    }

    interface  DiaLisn{
        fun onsubmit(naba: String,haba: String,quan:String)
    }


}
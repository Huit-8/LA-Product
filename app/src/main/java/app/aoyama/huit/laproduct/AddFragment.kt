package app.aoyama.huit.laproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.aoyama.huit.laproduct.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater,container,false)

        //MainFragmentへ移動するコードを書く
        binding.goHomeButton.setOnClickListener {

        }

        return binding.root

    }


}
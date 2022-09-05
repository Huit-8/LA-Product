package app.aoyama.huit.laproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import app.aoyama.huit.laproduct.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)

        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment
//        val navHostFragment = requireActivity().supportFragmentManager. as NavHostFragment
        val navController = navHostFragment.navController

        val action = MainFragmentDirections.actionMainFragmentToAddFragment()

        //memoを入力するフラグメントへ移動する
        binding.goMemoButton.setOnClickListener {
            navController.navigate(action)

        }

        return binding.root
    }


}
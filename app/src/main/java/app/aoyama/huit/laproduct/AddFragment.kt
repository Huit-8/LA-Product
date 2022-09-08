package app.aoyama.huit.laproduct

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.navigation.fragment.NavHostFragment
import app.aoyama.huit.laproduct.databinding.FragmentAddBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding

    lateinit var db: AppDatabase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater,container,false)

        //データベースの初期化
        db = AppDatabase.getInstance(requireContext())!!




        //mainFragmentへ遷移する準備をする
        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val action = AddFragmentDirections.actionAddFragmentToMainFragment()

        //MainFragmentへ移動するコードを書く
        binding.goHomeButton.setOnClickListener {
            navController.navigate(action)
            //EditTextに入力された文字列を取得する
            val addText = binding.editTextField.text.toString()

            //入力された文字をデータベースに保存する
            val memo:Memo = Memo(
                text = addText,
            )
            db.memoDao().insert(memo)

        }

        return binding.root

    }


}
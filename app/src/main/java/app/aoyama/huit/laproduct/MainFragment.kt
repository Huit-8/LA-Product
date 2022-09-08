package app.aoyama.huit.laproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import app.aoyama.huit.laproduct.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    lateinit var adapter: MemoListAdapter

    lateinit var db: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)

        //データベースの初期化
        db = AppDatabase.getInstance(requireContext())!!

        //データベースから入力されたメモのリストを取得する
        val memoList = db.memoDao().getTextList()


        //リサイクラービューをセットする
        adapter = MemoListAdapter()
        val recyclerView = binding.memoList
        recyclerView.adapter = adapter
        val itemDecoration = DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecoration)

        //リサイクラービューに値を入れるためのリストを作成
//        val memoList = listOf<String>("らくだ","たぬき","りす！","きつね","さる","とり","いぬ","いのしし",
//        "とら","ねずみ","うし","うま","しか","ペンギン","らっこ","ひよこ","パンダ","ハムスター","ねこ")

        //リサイクラービューに値を入れる
        recyclerView.post {
            adapter.updateMemoList(memoList)
        }


        //AddFragmentへ遷移する準備をする
        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val action = MainFragmentDirections.actionMainFragmentToAddFragment()

        //memoを入力するフラグメントへ移動する
        binding.goMemoButton.setOnClickListener {
            navController.navigate(action)

        }

        return binding.root
    }


}
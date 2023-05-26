package com.example.mission8

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.mission8.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    companion object {
        lateinit var helper: AppDB
    }
    var memoList = mutableListOf<Memo>()
    lateinit var memoAdapter: MainAdapter
    private lateinit var spheart: SharedPreferences
    private lateinit var spstar: SharedPreferences
    lateinit var memotext : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        memotext = viewBinding.editMemo

        helper = Room.databaseBuilder(this, AppDB::class.java, "memo")
            .allowMainThreadQueries()
            .build()

        spheart = getSharedPreferences("hc", Context.MODE_PRIVATE)
        spstar = getSharedPreferences("sc", Context.MODE_PRIVATE)

        memoAdapter = MainAdapter(memoList,spstar,spheart){ memo ->
            updateMemo(memo)
        }

        setmemo()

        viewBinding.rvMemo.adapter = memoAdapter
        viewBinding.rvMemo.layoutManager = LinearLayoutManager(this@MainActivity)

        viewBinding.btnMemo.setOnClickListener {
            val text =  memotext.text.toString()
            if(text.isNotEmpty()){
                val memo = Memo(text)
                helper.memoDao().insert(memo)

                setmemo()
            }
            memotext.setText("")
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.star -> {
                val intent = Intent(this, StarActivity::class.java)
                startActivity(intent)
                true
            }
            else -> {
                memoAdapter.notifyDataSetChanged()
                true
            }
        }
    }

    private fun setmemo(){
        memoList.clear()
        memoList.addAll(helper.memoDao().getAll())
        memoAdapter.notifyDataSetChanged()
    }

    private fun updateMemo(memo: Memo) {
        helper.memoDao().update(memo)
    }
}
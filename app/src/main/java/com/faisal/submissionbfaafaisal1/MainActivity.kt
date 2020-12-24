package com.faisal.submissionbfaafaisal1

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : DataAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataFolower: Array<String>
    private lateinit var dataFolowing: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var datas = arrayListOf<Data>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvList : ListView = findViewById(R.id.lv_list)
        adapter = DataAdapter(this)
        lvList.adapter = adapter
        prepare()
        addItem()

        lvList.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val listData = Data("","","","","","","",0)
            listData.username = dataUsername[position]
            listData.repository = dataRepository[position]
            listData.company = dataCompany[position]
            listData.name = dataName[position]
            listData.location = dataLocation[position]
            listData.following = dataFolowing[position]
            listData.folowers = dataFolower[position]
            listData.avatar = dataPhoto.getResourceId(position,position)
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA,listData)
            startActivity(intent)
        }

    }

    fun prepare(){
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataLocation = resources.getStringArray(R.array.location)
        dataFolowing = resources.getStringArray(R.array.following)
        dataFolower = resources.getStringArray(R.array.followers)
        dataCompany = resources.getStringArray(R.array.company)
        dataRepository = resources.getStringArray(R.array.repository)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
    }

    fun addItem(){
        for (position in dataName.indices){
            val listData = Data(
                dataUsername[position],
                dataRepository[position],
                dataCompany[position],
                dataName[position],
                dataLocation[position],
                dataFolowing[position],
                dataFolower[position],
                dataPhoto.getResourceId(position,-1)
            )
            datas.add(listData)
        }

        adapter.data = datas
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}
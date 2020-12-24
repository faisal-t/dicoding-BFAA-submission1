package com.faisal.submissionbfaafaisal1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val txtName : TextView = findViewById(R.id.txt_name_detail)
        val txtLocation : TextView = findViewById(R.id.txt_location_detail)
        val txtUsername : TextView = findViewById(R.id.txt_username_detail)
        val txtFollower : TextView = findViewById(R.id.txt_follwer_detail)
        val txtFollowing : TextView = findViewById(R.id.txt_following_detail)
        val txtRepository : TextView = findViewById(R.id.txt_repository_detail)
        val txtCompany : TextView = findViewById(R.id.txt_company_detail)
        val imgDetail : ImageView = findViewById(R.id.img_photo_detail)

        val dataDetail : Data ?= intent.getParcelableExtra(EXTRA_DATA)
        txtName.text = dataDetail?.name
        txtCompany.text = dataDetail?.company
        txtLocation.text = dataDetail?.location
        txtUsername.text = dataDetail?.username
        txtFollower.text = dataDetail?.folowers
        txtFollowing.text = dataDetail?.following
        txtRepository.text = dataDetail?.repository
        imgDetail.setImageResource(dataDetail!!.avatar)

    }

    companion object{
        var EXTRA_DATA = "0"
    }
}
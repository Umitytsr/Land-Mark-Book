package com.umitytsr.kotlinlandmarkbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.umitytsr.kotlinlandmarkbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList : ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landmarkList = ArrayList<Landmark>()

        //Data
        val coronIsland = Landmark("Coron Island","Philippines",R.drawable.coronisland)
        val alpineMountains = Landmark("Alpine Mountains","Switzerland",R.drawable.alpdaglari)
        val aurora = Landmark("Aurora","Norway",R.drawable.aurora)
        val islandOfStars = Landmark("Island Of Stars","Maldives",R.drawable.yildizlaradasi)

        landmarkList.add(coronIsland)
        landmarkList.add(alpineMountains)
        landmarkList.add(aurora)
        landmarkList.add(islandOfStars)


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val landmarkAdapter = LandmarkAdapter(landmarkList)
        binding.recyclerView.adapter = landmarkAdapter

    }
}
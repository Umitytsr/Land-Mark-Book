package com.umitytsr.kotlinlandmarkbook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umitytsr.kotlinlandmarkbook.databinding.ActivityMainBinding
import com.umitytsr.kotlinlandmarkbook.databinding.RecyclerRowBinding

class LandmarkAdapter(val landmarkList: ArrayList<Landmark>) : RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>(){

    class LandmarkHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkHolder {
        /*onCreateViewHolder -> yukardaki oluşturulduğumuz ViewHolder ilk oluşturulduğunda ne olacağını
        soruyo.Burada layout ile bağlama işlemi yapılır.yani daha remin oluşturduğumuz recycler_row'u
        bağlayacaz */
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandmarkHolder(binding)
    }

    override fun onBindViewHolder(holder: LandmarkHolder, position: Int) {
        /* Bağlandıktan sonra ne olacak. Görünümün içinde ki textlerde ne gösterilecek */
        holder.binding.recyclerViewTextView.text = landmarkList.get(position).name

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("landmark",landmarkList.get(position))
            holder.itemView.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        /* Bunlardan kaç tane oluşturacağımız soruluyo.yani kaç tane görünüm gösterecek */
        return landmarkList.size
    }
}
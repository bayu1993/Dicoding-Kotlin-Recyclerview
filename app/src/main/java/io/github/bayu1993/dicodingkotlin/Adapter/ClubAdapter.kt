package io.github.bayu1993.dicodingkotlin.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import io.github.bayu1993.dicodingkotlin.R
import io.github.bayu1993.dicodingkotlin.model.Club
import kotlinx.android.synthetic.main.item_club.view.*

/**
 * Created by Bayu teguh pamuji on 8/29/18.
 * email : bayuteguhpamuji@gmail.com.
 */

class ClubAdapter (private val context: Context, private val items: List<Club>,  private val listener: (Club) -> Unit)
    : RecyclerView.Adapter<ClubAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_club,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ClubAdapter.ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val name = view.findViewById<TextView>(R.id.tv_club)
        private val image = view.findViewById<ImageView>(R.id.img_club)
        fun bind(item:Club, listener: (Club) -> Unit){
            name.text = item.name
            Glide.with(itemView.context).load(item.img_url).into(image)
            itemView.setOnClickListener {
                listener(item)
            }
        }
    }

}
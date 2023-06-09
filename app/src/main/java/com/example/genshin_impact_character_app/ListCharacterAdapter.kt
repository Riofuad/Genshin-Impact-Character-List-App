package com.example.genshin_impact_character_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListCharacterAdapter(private val listCharacter: ArrayList<Character>, public val currentRv: RecyclerView) :
    RecyclerView.Adapter<ListCharacterAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Character)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val tvWeapon: TextView = itemView.findViewById(R.id.tv_item_weapon)
        val tvStrip: TextView = itemView.findViewById(R.id.tv_strip)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_character, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listCharacter.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, weapon) = listCharacter[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.tvWeapon.text = weapon
        holder.tvStrip.text = " — "

        if (currentRv.layoutManager is GridLayoutManager) {
            holder.tvWeapon.visibility = View.INVISIBLE
            holder.tvStrip.visibility = View.INVISIBLE
        } else {
            holder.tvWeapon.visibility = View.VISIBLE
            holder.tvStrip.visibility = View.VISIBLE
        }

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listCharacter[holder.adapterPosition]) }
    }
}
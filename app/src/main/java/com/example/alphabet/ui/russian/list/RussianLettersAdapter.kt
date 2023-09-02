package com.example.alphabet.ui.russian.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alphabet.R

class RussianLettersAdapter : RecyclerView.Adapter<RussianLettersAdapter.ViewHolder>() {

    var items: ArrayList<RussianData> = arrayListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onClick: (RussianData) -> Unit = {}

    var selectedItem = -1

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var llRoot: LinearLayout? = null
        private var tvLetter: TextView? = null
        private var tvDesc: TextView? = null

        init {
            llRoot = itemView.findViewById(R.id.ll_root)
            tvLetter = itemView.findViewById(R.id.tv_letter)
            tvDesc = itemView.findViewById(R.id.tv_desc)
        }

        @SuppressLint("NotifyDataSetChanged")
        fun onBind(data: RussianData, position: Int) {

            tvLetter?.text = data.letter
            tvDesc?.text = data.desc

            if (selectedItem == position){
                llRoot?.setBackgroundResource(R.drawable.bg_green)
            }else llRoot?.setBackgroundResource(R.drawable.bg_yellow)

            itemView.setOnClickListener {
                onClick.invoke(data)
                selectedItem = position
                notifyDataSetChanged()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_letter_rus, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position], position)
    }
}
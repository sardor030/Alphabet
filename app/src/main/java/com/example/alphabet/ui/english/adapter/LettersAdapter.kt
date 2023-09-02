package com.example.alphabet.ui.english.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.alphabet.R
import com.example.alphabet.ui.model.Letters

class LettersAdapter: RecyclerView.Adapter<LettersAdapter.ViewHolder>() {

    var items: ArrayList<Letters> = arrayListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onClick: (Letters) -> Unit = {}

    var selectedItem = -1

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private var btnLetter: Button? = null

        init {
            btnLetter = itemView.findViewById(R.id.btn_letter)
        }

        @SuppressLint("NotifyDataSetChanged")
        fun onBind(data: Letters, position: Int) {

            btnLetter?.text = data.letter.first().toString()

            if (selectedItem == position){
                btnLetter?.setBackgroundResource(R.drawable.ic_clicked)
            }else btnLetter?.setBackgroundResource(R.drawable.ic_un_clicked)

            itemView.setOnClickListener {
                onClick.invoke(data)
                selectedItem = position
                notifyDataSetChanged()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_litter,parent,false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position], position)
    }
}
package com.hun.trpghelper.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hun.trpghelper.R
import com.hun.trpghelper.dto.Dice
import kotlinx.android.synthetic.main.layout_item_dice.view.*

class DiceAdapter(private var items: ArrayList<Dice>) : RecyclerView.Adapter<DiceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.layout_item_dice, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.name.text = item.name
        holder.figure.text = item.figure.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addDice(name: String, figure: Int) {
        val dice = Dice().apply {
            this.name = name
            this.figure = figure
        }
        items.add(dice)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.text_name
        val figure: TextView = itemView.text_figure
    }
}

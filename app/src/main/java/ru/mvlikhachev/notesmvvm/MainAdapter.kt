package ru.mvlikhachev.notesmvvm

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item.view.*
import ru.mvlikhachev.notesmvvm.model.AppNote

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>(){

    private var mListNote = emptyList<AppNote>()

    class MainHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nameNote : TextView = view.itemNoteNameTextView
        val textNote : TextView = view.itemNoteTextTextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)

        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.textNote.text = mListNote[position].text
        holder.nameNote.text = mListNote[position].name
    }


    fun setList(list: List<AppNote>) {
        mListNote = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
       return mListNote.size
    }

}
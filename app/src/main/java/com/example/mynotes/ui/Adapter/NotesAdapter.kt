package com.example.mynotes.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.Model.Notes
import com.example.mynotes.R
import com.example.mynotes.databinding.ItemNotesBinding

class NotesAdapter(val requireContext: Context,val noteslist: List<Notes>) : RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {

    class notesViewHolder(val binding:ItemNotesBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val data = noteslist[position]
            holder.binding.notesTitle.text = data.title
            holder.binding.notesSubTitle.text = data.subTitle
            holder.binding.notesDate.text = data.date

        when(data.priority)
        {
            "1"->{
                holder.binding.viewPiority.setBackgroundResource(R.drawable.blue_dot)
            }
            "2"->{
                holder.binding.viewPiority.setBackgroundResource(R.drawable.pink_dot)
            }
            "3"->{
                holder.binding.viewPiority.setBackgroundResource(R.drawable.purple_dot)
            }
        }
    }

    override fun getItemCount()= noteslist.size
}
package com.rkm.notesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rkm.notesapp.R
import com.rkm.notesapp.databinding.HomeItemBinding
import com.rkm.notesapp.datamodel.notes

class notesAdapter(val list:List<notes>,val context: Context):RecyclerView.Adapter<notesAdapter.notesViewholder>() {

    class notesViewholder(val binding: HomeItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(context: Context,model:notes){

            binding.apply {

                when(model.priority){

                    "1"->{priorityimage.setImageResource(R.drawable.reddot)}
                    "2"-> {priorityimage.setImageResource(R.drawable.greendot)}

                }

                date.text=model.date
                notes.text=model.title


            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewholder {

        return notesViewholder(HomeItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: notesViewholder, position: Int) {

        holder.bind(context,list.get(position))
    }
}
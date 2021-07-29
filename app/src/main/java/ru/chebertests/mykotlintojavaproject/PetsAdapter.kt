package ru.chebertests.mykotlintojavaproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class PetsAdapter(private val repository: IRepository) : RecyclerView.Adapter<PetsAdapter.PetViewHolder>() {
    class PetViewHolder(val item : View) : RecyclerView.ViewHolder(item) {

        private val name : TextView
        private val age : TextView

        init {
            name = item.findViewById(R.id.pets_name)
            age = item.findViewById(R.id.pets_age)
        }

        fun bind(pet: Pets) {
            name.text = pet.name
            age.text = pet.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return PetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.bind(repository.getData()[position])
    }

    override fun getItemCount(): Int {
        return repository.getData().size
    }
}
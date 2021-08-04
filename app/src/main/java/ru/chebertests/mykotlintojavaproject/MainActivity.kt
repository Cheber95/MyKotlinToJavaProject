package ru.chebertests.mykotlintojavaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ru.chebertests.mykotlintojavaproject.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository : IRepository = Repository()
        val recyclerPets = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = PetsAdapter(repository)
        recyclerPets.adapter = adapter

        val simpleButton = findViewById<Button>(R.id.simple_button)
        simpleButton.setOnClickListener {
            val newRepository = filterCat(repository.getData()[0], repository.getData()[4], filterAge = 5)
            Toast.makeText(this,newRepository.size.toString(),Toast.LENGTH_LONG).show()
        }
    }

    fun filterCat(vararg pets : Pets, filterAge: Int) : ArrayList<Pets> {
        val subRepo : ArrayList<Pets> = arrayListOf()
        for (p in pets) {
            if (p.age < filterAge) {
                subRepo.add(p)
            }
        }
        return subRepo
    }
}
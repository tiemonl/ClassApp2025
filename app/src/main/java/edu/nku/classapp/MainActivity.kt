package edu.nku.classapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val names = listOf("Rick", "Morty", "Summer", "Beth", "Jerry")
    private val lastNames = listOf("Sanchez", "Dog", "Cat", "Smith")
    private val planets = listOf("Earth", "Mars", "Jupiter", "Saturn", "Neptune")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val characters = mutableListOf<RickAndMortyCharacter>()


        for (i in 0..30) {
            characters.add(createCharacter(i))
        }

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RickAndMortyCharacterAdapter(characters)
    }

    private fun createCharacter(id: Int) = RickAndMortyCharacter(
        age = Random.nextInt(1, 100),
        id = id,
        name = names.random() + " " + lastNames.random(),
        planet = planets.random(),
        picture = R.drawable.ic_launcher_background
    )
}
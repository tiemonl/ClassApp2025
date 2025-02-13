package edu.nku.classapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class RickAndMortyCharacterListFragment : Fragment() {

    private val names = listOf("Rick", "Morty", "Summer", "Beth", "Jerry")
    private val lastNames = listOf("Sanchez", "Dog", "Cat", "Smith")
    private val planets = listOf("Earth", "Mars", "Jupiter", "Saturn", "Neptune")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_character_list, container, false)

        val characters = mutableListOf<RickAndMortyCharacter>()
        for (i in 0..30) {
            characters.add(createCharacter(i))
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RickAndMortyCharacterAdapter(characters)

        return view
    }

    private fun createCharacter(id: Int) = RickAndMortyCharacter(
        age = Random.nextInt(1, 100),
        id = id,
        name = names.random() + " " + lastNames.random(),
        planet = planets.random(),
        picture = "https://rickandmortyapi.com/api/character/avatar/${Random.nextInt(1, 100)}.jpeg"
    )

}
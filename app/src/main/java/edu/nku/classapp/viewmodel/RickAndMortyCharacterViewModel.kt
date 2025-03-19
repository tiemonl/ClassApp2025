package edu.nku.classapp.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.nku.classapp.model.RickAndMortyCharacter
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class RickAndMortyCharacterViewModel @Inject constructor() : ViewModel() {
    private val characters = mutableListOf<RickAndMortyCharacter>()

    private val names = listOf("Rick", "Morty", "Summer", "Beth", "Jerry")
    private val lastNames = listOf("Sanchez", "Dog", "Cat", "Smith")
    private val planets = listOf("Earth", "Mars", "Jupiter", "Saturn", "Neptune")

    init {
        createCharacters()
    }

    fun fillData() = characters.toList()

    fun fetchById(id: Int) = characters.first { it.id == id }

    private fun createCharacters() = (0..30).map { id ->
        characters.add(
            RickAndMortyCharacter(
                age = Random.nextInt(1, 100),
                id = id,
                name = names.random() + " " + lastNames.random(),
                planet = planets.random(),
                picture = "https://rickandmortyapi.com/api/character/avatar/${
                    Random.nextInt(
                        1,
                        100
                    )
                }.jpeg"
            )
        )
    }
}
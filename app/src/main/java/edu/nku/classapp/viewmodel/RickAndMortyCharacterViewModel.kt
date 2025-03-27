package edu.nku.classapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.nku.classapp.data.model.RickAndMortyApiResponse
import edu.nku.classapp.data.repository.RickAndMortyRepository
import edu.nku.classapp.model.RickAndMortyCharacterResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class RickAndMortyCharacterViewModel @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
) : ViewModel() {

    private val _characters = MutableStateFlow<RickAndMortyCharacterState>(RickAndMortyCharacterState.Loading)
    val characters: StateFlow<RickAndMortyCharacterState> = _characters.asStateFlow()

    fun fillData() = viewModelScope.launch {
        when (val response = rickAndMortyRepository.getCharacters()) {
            RickAndMortyApiResponse.Error -> _characters.value = RickAndMortyCharacterState.Failure
            is RickAndMortyApiResponse.Success -> _characters.value = RickAndMortyCharacterState.Success(response.characters)
        }

    }

    sealed class RickAndMortyCharacterState {
        data class Success(val characters: List<RickAndMortyCharacterResponse.Character>): RickAndMortyCharacterState()
        data object Failure : RickAndMortyCharacterState()
        data object Loading : RickAndMortyCharacterState()
    }

}
package edu.nku.classapp.data.model

import edu.nku.classapp.model.RickAndMortyCharacterResponse

sealed class RickAndMortyApiResponse {
    data class Success(val characters: List<RickAndMortyCharacterResponse.Character>): RickAndMortyApiResponse()
    data object Error : RickAndMortyApiResponse()
}
package edu.nku.classapp.data

import edu.nku.classapp.model.RickAndMortyCharacterResponse
import retrofit2.Response
import retrofit2.http.GET

// https://rickandmortyapi.com/api/character
interface RickAndMortyApi {
    @GET("/api/character")
    suspend fun getCharacters(): Response<RickAndMortyCharacterResponse>
}
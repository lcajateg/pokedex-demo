package com.example.pokedex.data

import com.example.pokedex.model.PokemonListResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiInterface {
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit:Int, @Query("offset") offset: Int):
            Call<PokemonListResponse>

//    @GET("pokemon/{pokemonName}")
//    fun pokemonDetail(@Path("pokemonName}") pokemonName: String):
//    Call<Response>
    // aQUI SE PUEDE PONER TODOS LOS ENDPOINTS QUE NECESITES
}
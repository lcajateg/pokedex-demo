package com.example.pokedex.model

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    val count: Int,
    val next: String,
    val previous: String,
    @SerializedName("results") val pokemons: List<Pokemon>
)



//count:1118
//next:"https://pokeapi.co/api/v2/pokemon?offset=300&limit=100"
//previous:"https://pokeapi.co/api/v2/pokemon?offset=100&limit=100"
//name:"unown"
//url:"https://pokeapi.co/api/v2/pokemon/201/"

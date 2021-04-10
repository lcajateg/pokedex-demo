package com.example.pokedex.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.adapter.RVPokemonAdapter
import com.example.pokedex.data.ClientConfig
import com.example.pokedex.data.PokeApiService
import com.example.pokedex.databinding.ActivityPokedexBinding
import com.example.pokedex.model.PokemonListResponse
import kotlin.Exception

class PokedexActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokedexBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // Pasar el on click listener para mostrar el detalle del pokemon

        val service = PokeApiService(config = ClientConfig())

        runOnUiThread {
            val response: PokemonListResponse? = service.pokemonList(100, 0).execute().let {
                if (it.isSuccessful) {
                    it.body()
                } else {
                    throw Exception()
                }
            }

            val pokemonList = response!!.pokemons


            val adapter = RVPokemonAdapter(pokemonList)

            binding.rvPokemonList.adapter = adapter

            binding.rvPokemonList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }



    }
}
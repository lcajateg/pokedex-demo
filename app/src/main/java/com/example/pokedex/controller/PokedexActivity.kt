package com.example.pokedex.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.adapter.RVPokemonAdapter
import com.example.pokedex.data.ClientConfig
import com.example.pokedex.data.PokeApiService
import com.example.pokedex.databinding.ActivityPokedexBinding
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonListResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.Exception

class PokedexActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokedexBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Pasar el on click listener para mostrar el detalle del pokemon

        val service = PokeApiService(config = ClientConfig())

        CoroutineScope(Dispatchers.IO).launch {
            service.getPokemonList(100, 0).enqueue(object : Callback<PokemonListResponse> {
                // 200 - 300
                override fun onResponse(
                    call: Call<PokemonListResponse>,
                    response: Response<PokemonListResponse>
                ) {
                    if (response.isSuccessful) {
                        showPokemons(response.body()?.pokemons)
                    }
                }

                override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                    // Todo poner un toast
                }
            })
        }
    }

    private fun showPokemons(pokemons: List<Pokemon>?) {
        pokemons?.let {
            val adapter = RVPokemonAdapter(it)

            binding.rvPokemonList.adapter = adapter

            binding.rvPokemonList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
    }
}
package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.databinding.ActivityPokedexBinding
import com.example.pokedex.model.Pokemon

class PokedexActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokedexBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonList = MutableList(10) { i -> Pokemon(name = "Pokemon $i", url = "http://pokemon.com/$i") }

        val adapter = RVPokemonAdapter(pokemonList)

        binding.rvPokemonList.adapter = adapter

        binding.rvPokemonList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
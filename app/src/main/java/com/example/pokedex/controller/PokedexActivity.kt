package com.example.pokedex.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pokedex.databinding.ActivityPokedexBinding
import com.example.pokedex.databinding.FragmentPokemonListBinding

class PokedexActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokedexBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentlist: Fragment = supportFragmentManager.findFragmentById(com.example.pokedex.R.id.fragment_list) as PokemonListFragment


    }
}
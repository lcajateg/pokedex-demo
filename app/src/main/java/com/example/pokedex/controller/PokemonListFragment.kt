package com.example.pokedex.controller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.R
import com.example.pokedex.adapter.RVPokemonAdapter
import com.example.pokedex.data.ClientConfig
import com.example.pokedex.data.PokeApiService
import com.example.pokedex.databinding.FragmentPokemonListBinding
import com.example.pokedex.model.Pokemon
import com.example.pokedex.model.PokemonListResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PokemonListFragment : Fragment() {

    private lateinit var binding: FragmentPokemonListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPokemonListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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

            binding.rvPokemonList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
}






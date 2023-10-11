package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDto;

import java.util.List;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);

    List<PokemonDto> getAllPokemon();

    PokemonDto getPokemonById(long id);

    PokemonDto updatePokemon(PokemonDto pokemonDto, long id);
}

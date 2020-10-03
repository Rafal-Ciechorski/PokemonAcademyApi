package pl.sdaacademy.PokemonAcademyApi.apploader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.apploader.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonLoaderService {

    private final PokeApiRepository pokeApiRepository;
    private final PokemonRepository pokemonRepository;

    @Autowired
    PokemonLoaderService(PokeApiRepository pokeApiRepository, PokemonRepository pokemonRepository){
        this.pokeApiRepository=pokeApiRepository;
        this.pokemonRepository=pokemonRepository;
    }

    public void loadPokemonList(String id, String name){
        PokemonResponse pokemonResponse;
        List<PokemonResult> pokemonResults = new ArrayList<>();
        int offset = 0;
        int limit=20;
        do {
             pokemonResponse = pokeApiRepository.getPokemonResponse(offset,limit);
            pokemonResults.addAll(pokemonResponse.getResults());
            offset+=limit;

        }while (pokemonResponse.getNext() != null);
    }





}

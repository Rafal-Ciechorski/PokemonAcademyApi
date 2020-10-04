package pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.repository.PokemonDetailsRepository;
import pl.sdaacademy.PokemonAcademyApi.apploader.repository.PokeApiRepository;
import pl.sdaacademy.PokemonAcademyApi.apploader.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.apploader.repository.PokemonRepository;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    @Autowired
    PokemonService(PokemonRepository pokemonRepository){
        this.pokemonRepository=pokemonRepository;
    }

    public Pokemon getPokemon(String name){
        Pokemon pokemon = pokemonRepository.findByName(name).orElseThrow(()->{
            throw new NoPokemonFoundException(name);
        });
        return pokemon;

    }


}

package pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.repository.PokemonDetailsRepository;
import pl.sdaacademy.PokemonAcademyApi.apploader.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.apploader.repository.PokemonRepository;

@Service
public class PokemonDetailsService {

    private final PokemonRepository pokemonRepository;
    private final PokemonDetailsRepository pokemonDetailsRepository;

    @Autowired
    PokemonDetailsService(PokemonRepository pokemonRepository, PokemonDetailsRepository pokemonDetailsRepository){
        this.pokemonRepository=pokemonRepository;
        this.pokemonDetailsRepository = pokemonDetailsRepository;
    }

    public Pokemon getPokemon(String name){
        Pokemon pokemon = pokemonRepository.findByName(name).orElseThrow(()->{
            throw new NoPokemonFoundException(name);
        });
        return pokemon;

    }


}

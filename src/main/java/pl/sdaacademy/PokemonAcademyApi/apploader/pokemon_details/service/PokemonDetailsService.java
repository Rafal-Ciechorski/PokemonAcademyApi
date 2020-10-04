package pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.repository.PokemonDetailsRepository;
import pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.repository.PokemonDetailsResponse;
import pl.sdaacademy.PokemonAcademyApi.apploader.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.apploader.repository.PokemonRepository;

@Service
public class PokemonDetailsService {

    private final PokemonRepository pokemonRepository;
    private final PokemonDetailsRepository pokemonDetailsRepository;
    private final PokemonDetailsTransformer pokemonDetailsTransformer;

    @Autowired
    PokemonDetailsService(PokemonRepository pokemonRepository, PokemonDetailsRepository pokemonDetailsRepository, PokemonDetailsTransformer pokemonDetailsTransformer){
        this.pokemonRepository=pokemonRepository;
        this.pokemonDetailsRepository = pokemonDetailsRepository;
        this.pokemonDetailsTransformer = pokemonDetailsTransformer;
    }

    public PokemonDetails getPokemon(String name){
        Pokemon pokemon = pokemonRepository.findByName(name).orElseThrow(()->{
            throw new NoPokemonFoundException(name);
        });
        PokemonDetailsResponse response = pokemonDetailsRepository.getPokemonDetailsResponse(pokemon.getUrl());

        return pokemonDetailsTransformer.transformToPokemonDetails(response);

    }


}

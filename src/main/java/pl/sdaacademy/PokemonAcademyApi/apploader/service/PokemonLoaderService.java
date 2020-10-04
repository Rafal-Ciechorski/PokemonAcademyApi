package pl.sdaacademy.PokemonAcademyApi.apploader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.apploader.common.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.apploader.common.repository.PokemonRepository;
import pl.sdaacademy.PokemonAcademyApi.apploader.repository.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonLoaderService {

    private final PokeApiRepository pokeApiRepository;
    private final PokemonRepository pokemonRepository;
    private final PokemonTransformer pokemonTransformer;
    private final int start_offset;
    private final int limit;

    @Autowired
    PokemonLoaderService(PokeApiRepository pokeApiRepository, PokemonRepository pokemonRepository,
                         PokemonTransformer pokemonTransformer, @Value("${pokeapi.start_offset}") int start_offset,
                         @Value("${pokeapi.limit}") int limit) {
        this.pokeApiRepository = pokeApiRepository;
        this.pokemonRepository = pokemonRepository;
        this.pokemonTransformer = pokemonTransformer;
        this.start_offset = start_offset;
        this.limit = limit;
    }

    @PostConstruct
    public void loadPokemonList() {
        PokemonResponse pokemonResponse;
        List<PokemonResult> pokemonResults = new ArrayList<>();
        int offset = start_offset;
        int limit = this.limit;
        do {
            pokemonResponse = pokeApiRepository.getPokemonResponse(offset, limit);
            pokemonResults.addAll(pokemonResponse.getResults());
            offset += limit;
        } while (pokemonResponse.getNext() != null);

        List<Pokemon> pokemons = pokemonTransformer.transformToPokemonList(pokemonResults);
        pokemonRepository.saveAll(pokemons);

//
//        List<Pokemon> pokemons = pokemonResults.stream()
//                .map(pokemonResult -> {
//                    String[] urlData = pokemonResult.getUrl().split("/");
//                    int id1 = Integer.parseInt(urlData[urlData.length-1]);
//                    return new Pokemon(id1,pokemonResult.getName(), pokemonResult.getUrl());
//                }).collect(Collectors.toList());
//        pokemonRepository.saveAll(pokemons);
//
    }
}

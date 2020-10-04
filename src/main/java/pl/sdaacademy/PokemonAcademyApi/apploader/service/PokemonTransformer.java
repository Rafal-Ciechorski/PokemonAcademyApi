package pl.sdaacademy.PokemonAcademyApi.apploader.service;

import org.springframework.stereotype.Component;
import pl.sdaacademy.PokemonAcademyApi.apploader.common.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.apploader.repository.PokemonResult;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PokemonTransformer {

    public Pokemon transformToPokemon(PokemonResult pokemonResult) {
        String[] urlData = pokemonResult.getUrl().split("/");
        int id1 = Integer.parseInt(urlData[urlData.length - 1]);
        return new Pokemon(id1, pokemonResult.getName(), pokemonResult.getUrl());
    }

    public List<Pokemon> transformToPokemonList(List<PokemonResult> pokemonResults) {
        return pokemonResults.stream()
                .map(this::transformToPokemon)
                .collect(Collectors.toList());
    }

}

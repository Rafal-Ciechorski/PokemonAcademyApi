package pl.sdaacademy.PokemonAcademyApi.apploader.common.service;

public class NoPokemonFoundException extends RuntimeException {

    public NoPokemonFoundException(String pokemonName) {
        super(String.format("No pokemon %s found!", pokemonName));
    }

}

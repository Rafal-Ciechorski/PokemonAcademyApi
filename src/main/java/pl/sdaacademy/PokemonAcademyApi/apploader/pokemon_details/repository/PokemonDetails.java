package pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.repository;

import java.util.List;

public class PokemonDetails {

    private List<String> abilities;
    private List<String> types;
    private String imageUrl;
    private int weight;
    private int height;
    private String name;

    public PokemonDetails(){

    }

    public PokemonDetails(List<String> abilities, List<String> types, String imageUrl, int weight, int height, String name) {
        this.abilities = abilities;
        this.types = types;
        this.imageUrl = imageUrl;
        this.weight = weight;
        this.height = height;
        this.name = name;
    }
}

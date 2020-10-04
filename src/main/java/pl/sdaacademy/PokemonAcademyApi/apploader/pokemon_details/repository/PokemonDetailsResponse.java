package pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokemonDetailsResponse {

    @JsonProperty("abilities")
    private List<Ability> abilities;

    @JsonProperty("sprites")
    private Sprites sprites;

    @JsonProperty("types")
    private List<Type> types;

    @JsonProperty("name")
    private String name;

    @JsonProperty("weight")
    private int weight;

    @JsonProperty("height")
    private int height;

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

package pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sprites {

    private Other other;

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }
}

package pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ability {

    @JsonProperty("ability")
    private AbilityDetails abilityDetails;

    public AbilityDetails getAbilityDetails(){
        return abilityDetails;
    }


}

package pl.sdaacademy.PokemonAcademyApi.apploader.repository;

import java.util.List;

public class PokemonResponse {

    private String next;

    private List<PokemonResult> results;

    public String getNext(){
        return next;
    }
}

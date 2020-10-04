package pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class PokemonDetailsRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public PokemonDetailsRepository(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public PokemonDetailsResponse getPokemonDetailsResponse(String urlAddress){
        return restTemplate.getForObject(urlAddress, PokemonDetailsResponse.class);
    }

}

package pl.sdaacademy.PokemonAcademyApi.apploader.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Repository
public class PokeApiRepository {

    //private static final String URL = "https://pokeapi.co/api/v2/pokemon?offset=%d&limit=%d";
    private final String urlAddress;
    private final RestTemplate restTemplate;

    @Autowired
    public PokeApiRepository(RestTemplate restTemplate, @Value("${pokeapi.url}") String urlAddress){
        this.urlAddress= urlAddress;
        this.restTemplate = restTemplate;
    }

    public PokemonResponse getPokemonResponse(int offset, int limit){
        //RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(String.format(urlAddress, offset,limit), PokemonResponse.class);


        //return restTemplate.getForObject(String.format(URL, offset,limit), PokemonResponse.class);
    }

}


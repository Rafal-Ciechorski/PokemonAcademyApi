package pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.apploader.pokemon_details.service.PokemonDetailsService;

@RequestMapping("/pokemons")
@RestController
public class PokemonController {

    private final PokemonDetailsService pokemonService;

    @Autowired
    public PokemonController(PokemonDetailsService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{name}")
    public PokemonDetails getPokemon(@PathVariable String name) {
        return pokemonService.getPokemon(name);
    }


}

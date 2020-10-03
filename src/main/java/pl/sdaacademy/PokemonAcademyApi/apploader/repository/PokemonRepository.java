package pl.sdaacademy.PokemonAcademyApi.apploader.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.client.RestTemplate;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {


}

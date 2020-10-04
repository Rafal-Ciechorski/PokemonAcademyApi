package pl.sdaacademy.PokemonAcademyApi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppComponentProvider {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

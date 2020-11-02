package com.compasso.selection.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.compasso.selection.DTO.CityDTO;
import com.compasso.selection.controller.CityController;
import com.compasso.selection.entity.State;
import com.compasso.selection.repository.StateRepository;
@Configuration
public class LoadData {
    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(StateRepository repository, CityController cityController) {

        return args -> {
            log.info("Pre carregamento " + repository.save(new State("CE", "Ceará")));
            log.info("Pre carregamento " + repository.save(new State("SC", "Santa Catarina")));
            log.info("Pre carregamento " + repository.save(new State("AC", "Acre" )));
            cityController.addCity(new CityDTO("Florianópolis", "SC"));
    		cityController.addCity(new CityDTO("Itajaí", "SC"));
    		cityController.addCity(new CityDTO("Joinville", "SC"));
        };
    }

}

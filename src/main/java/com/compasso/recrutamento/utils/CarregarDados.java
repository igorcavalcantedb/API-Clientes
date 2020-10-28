package com.compasso.recrutamento.utils;
import com.compasso.recrutamento.entity.Estado;
import com.compasso.recrutamento.repository.EstadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Configuration
public class CarregarDados {
    private static final Logger log = LoggerFactory.getLogger(CarregarDados.class);

    @Bean
    CommandLineRunner initDatabase(EstadoRepository repository) {

        return args -> {
            log.info("Pre carregamento " + repository.save(new Estado("CE", "Ceará")));
            log.info("Pre carregamento " + repository.save(new Estado("SC", "Santa Catarina")));
            log.info("Pre carregamento " + repository.save(new Estado("AC", "Acre" )));
        };
    }

}

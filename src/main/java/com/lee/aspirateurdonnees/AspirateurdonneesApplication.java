package com.lee.aspirateurdonnees;

import com.lee.aspirateurdonnees.model.Cours;
import com.lee.aspirateurdonnees.depot.CoursDep;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.*;

@SpringBootApplication
public class AspirateurdonneesApplication {

    public static void main(String[] args) {

        SpringApplication.run(AspirateurdonneesApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CoursDep dep){
        return args -> {
            dep.save(new Cours("cours", "lee", "apprenant",
                            LocalDateTime.of(2018, 1, 1, 8, 30),
                            LocalDateTime.of(2018, 1, 1, 10, 0),
                            Math.abs(Duration.between   (   LocalDateTime.of(2018, 1, 1, 8, 30),
                                                            LocalDateTime.of(2018, 1, 1, 10, 0)
                                                        ).toMinutes()),
                            Boolean.FALSE));

            dep.save(new Cours("conférence", "business intelligence", "organisation",
                            LocalDateTime.of(2018, 1, 1, 10, 15),
                            LocalDateTime.of(2018, 1, 1, 11, 45),
                            Math.abs(Duration.between   (   LocalDateTime.of(2018, 1, 1, 10, 15),
                                                            LocalDateTime.of(2018, 1, 1, 11, 45)
                                                        ).toMinutes()),
                            Boolean.TRUE));

            dep.save(new Cours("débat", "le big data", "animation",
                            LocalDateTime.of(2018, 1, 2, 8, 30),
                            LocalDateTime.of(2018, 1, 2, 11, 45),
                            Math.abs(Duration.between   (   LocalDateTime.of(2018, 1, 2, 8, 30),
                                                            LocalDateTime.of(2018, 1, 2, 11, 45)
                                                        ).toMinutes()),
                            Boolean.TRUE));

        };
    }

}


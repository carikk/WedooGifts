package fr.wedoogifts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Démarrage de l'application.
 */
@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan(basePackages={"Controllers"})
public class Application1 {

    /**
     * Démarrage de l'application.
     *
     * @param args les paramètres
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application1.class, args);
    }
}

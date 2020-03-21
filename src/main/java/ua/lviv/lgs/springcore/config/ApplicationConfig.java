package ua.lviv.lgs.springcore.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.lviv.lgs.springcore.Client;

@Configuration
public class ApplicationConfig {

    @Bean
    @Qualifier("secondClient")
    public Client getClient() {
        Client client = new Client();
        client.setFirstName("Jon");
        client.setLastName("Snow");
        client.setId(1);
        return client;
    }

    @Bean
    @Qualifier("defaultClient")
    public Client getClient2() {
        Client client = new Client();
        client.setFirstName("Ivan");
        client.setLastName("Koziv");
        client.setId(3);
        return client;
    }
}

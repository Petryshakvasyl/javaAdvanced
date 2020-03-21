package ua.lviv.lgs.springcore;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data

@Component
public class App {

    @Value("25")
    private Integer id;
    //@Autowired field injection
    private final EventLogger eventLogger;
    private final Client client;
    //constructor injection
    public App(EventLogger eventLogger, @Qualifier("defaultClient") Client client) {
        this.eventLogger = eventLogger;
        this.client = client;
    }

    //    private EventLogger eventLogger;

   // @Autowired setter injection
//    public void setClient(Client client) {
//        this.client = client;
//    }
}

package ua.lviv.lgs.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringCoreApplication.class, args);

//        Client client = (Client) ctx.getBean("client");
//        Client client2 = (Client) ctx.getBean("client2");
//        System.out.println(client);

        App app = ctx.getBean(App.class);

        System.out.println(app);

    }

}

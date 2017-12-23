package my.test.app1;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@EnableAutoConfiguration
@SpringBootApplication
public class App {

    private static Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        log.debug("Starting the app...");

        ApplicationContext appContext = SpringApplication.run(App.class, args);


    }

}

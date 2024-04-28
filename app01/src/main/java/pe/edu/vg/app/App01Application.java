package pe.edu.vg.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "pe.edu.vg.app.model")
@ComponentScan("pe.edu.vg.model")
public class App01Application {
    public static void main(String[] args) {
        SpringApplication.run(App01Application.class, args);
    }
}



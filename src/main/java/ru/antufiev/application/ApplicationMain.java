package ru.antufiev.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.antufiev.application.entity.Application;
import ru.antufiev.application.repository.ApplicationRepository;

@SpringBootApplication
public class ApplicationMain {

  private static final Logger log = LoggerFactory.getLogger(ApplicationMain.class);

  public static void main(String[] args) {
    SpringApplication.run(ApplicationMain.class, args);
  }


  @Bean
  public CommandLineRunner test(ApplicationRepository repository) {
    return args -> {
      repository.save(new Application("FirstApp:", "My first app"));
      repository.save(new Application("SecondApp:", "My second app"));

      for (Application app: repository.findAll()) {
        log.info("The application: " + app.toString());
      }
    };
  }
}

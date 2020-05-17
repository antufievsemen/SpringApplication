package ru.antufiev.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.antufiev.application.entity.Application;
import ru.antufiev.application.entity.User;
import ru.antufiev.application.repository.ApplicationRepository;
import ru.antufiev.application.repository.UserRepository;

import java.util.Collections;

@Component
public class TestDataInit implements CommandLineRunner {

  @Autowired
  ApplicationRepository appRep;

  @Autowired
  UserRepository userRep;

  @Autowired
  PasswordEncoder pwdEncoder;

  @Override
  public void run(String... args) throws Exception {
    appRep.save(new Application("FirstApp:", "My first app"));
    appRep.save(new Application("SecondApp:", "My second app"));

    userRep.save(new User("user", pwdEncoder.encode("pwd"), Collections.singletonList("ROLE_USER")));
    userRep.save(new User("admin", pwdEncoder.encode("apwd"), Collections.singletonList("ROLE_ADMIN")));
  }
}

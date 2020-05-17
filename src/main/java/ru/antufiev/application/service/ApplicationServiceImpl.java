package ru.antufiev.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.antufiev.application.entity.Application;
import ru.antufiev.application.exception.ApplicationNotFoundException;
import ru.antufiev.application.repository.ApplicationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService{

  @Autowired
  private ApplicationRepository appRepository;

  @Override
  public List<Application> listApplication() {
    return (List<Application>) appRepository.findAll();
  }

  @Override
  public Application findApplication(long id) {
    Optional<Application> optionalApp = appRepository.findById(id);
    if (optionalApp.isPresent()) {
      return optionalApp.get();
    } else {
     throw new ApplicationNotFoundException("Application not found");
    }
  }

  @Override
  public Application addApplication(Application application) {
    return appRepository.save(application);
  }
}

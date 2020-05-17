package ru.antufiev.application.service;

import ru.antufiev.application.entity.Application;

import java.util.List;

public interface ApplicationService {
  List<Application> listApplication();
  Application findApplication(long id);
  Application addApplication(Application application);

}

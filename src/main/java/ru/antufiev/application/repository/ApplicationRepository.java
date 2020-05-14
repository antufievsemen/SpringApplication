package ru.antufiev.application.repository;

import org.springframework.data.repository.CrudRepository;
import ru.antufiev.application.entity.Application;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
}

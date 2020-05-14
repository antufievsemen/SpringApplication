package ru.antufiev.application.repository;

import org.springframework.data.repository.CrudRepository;
import ru.antufiev.application.entity.Release;

public interface ReleaseRepository extends CrudRepository<Release, Long> {
}

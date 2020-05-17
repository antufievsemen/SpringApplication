package ru.antufiev.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.antufiev.application.entity.Release;
import ru.antufiev.application.repository.ReleaseRepository;

import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService{

  @Autowired
  private ReleaseRepository releaseRepository;

  @Override
  public List<Release> listRelease() {
    return (List<Release>) releaseRepository.findAll();
  }
}

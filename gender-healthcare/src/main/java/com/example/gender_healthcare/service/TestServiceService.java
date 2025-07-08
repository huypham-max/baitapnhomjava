package com.example.genderhealthcare.service;

import com.example.genderhealthcare.model.TestService;
import com.example.genderhealthcare.repository.TestServiceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestServiceService {
  private final TestServiceRepository repo;
  public TestServiceService(TestServiceRepository repo) { this.repo = repo; }
  public List<TestService> findAll() { return repo.findAll(); }
  public TestService save(TestService s) { return repo.save(s); }
  public void delete(Long id) { repo.deleteById(id); }
}

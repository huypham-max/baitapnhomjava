package com.example.genderhealthcare.service;

import com.example.genderhealthcare.model.TestRequest;
import com.example.genderhealthcare.repository.TestRequestRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TestRequestService {
  private final TestRequestRepository repo;
  public TestRequestService(TestRequestRepository repo) { this.repo = repo; }

  public List<TestRequest> findAll() { return repo.findAll(); }
  public TestRequest save(TestRequest r) { return repo.save(r); }
  public List<TestRequest> findByStatus(TestRequest.Status s) { return repo.findByStatus(s); }
  public List<TestRequest> findByUser(String user) { return repo.findByUserId(user); }

  // Thống kê
  public long count() { return repo.count(); }
  public long countByStatus(TestRequest.Status s) { return repo.findByStatus(s).size(); }
  // Nhắc nhở ngày mai
  public List<TestRequest> remindTomorrow() {
    LocalDate t = LocalDate.now().plusDays(1);
    return repo.findAll().stream()
      .filter(r -> r.getDateTime().toLocalDate().equals(t))
      .toList();
  }
}

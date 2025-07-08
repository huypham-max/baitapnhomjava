package com.example.genderhealthcare.repository;

import com.example.genderhealthcare.model.TestRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TestRequestRepository extends JpaRepository<TestRequest, Long> {
  List<TestRequest> findByStatus(TestRequest.Status status);
  List<TestRequest> findByUserId(String userId);
}

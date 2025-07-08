package com.example.genderhealthcare.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TestRequest {
  public enum Status { PENDING, SCHEDULED, SAMPLE_COLLECTED, TESTING, COMPLETED }

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String userId;

  @ManyToOne
  @JoinColumn(name="service_id")
  private TestService service;

  private LocalDateTime dateTime;
  @Enumerated(EnumType.STRING)
  private Status status;
  private String result;

  // Constructors, getters, setters
  public TestRequest() {}
  public TestRequest(String userId, TestService service, LocalDateTime dateTime) {
    this.userId = userId;
    this.service = service;
    this.dateTime = dateTime;
    this.status = Status.PENDING;
    this.result = "";
  }
  // ... getters/setters omitted for brevity
}

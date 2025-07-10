package com.healthcare.repository;

import com.healthcare.entity.Question;
import com.healthcare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByCustomer(User customer);
}

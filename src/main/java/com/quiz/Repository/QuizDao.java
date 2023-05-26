package com.quiz.Repository;

import com.quiz.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {

    @Query("SELECT q FROM Quiz q WHERE q.status=ACTIVE")
    List<Quiz> findActiveQuizzes();

    Optional<Quiz> findById(Integer id);
}

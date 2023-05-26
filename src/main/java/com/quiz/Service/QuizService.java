package com.quiz.Service;

import com.quiz.DTO.QuizDTO;
import com.quiz.Exception.QuizException;
import com.quiz.Model.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface QuizService {

    public Quiz createQuiz(Quiz quiz) throws QuizException;
    public List<Quiz> getActiveQuiz() throws QuizException;
    public List<Quiz> getAllQuizzes() throws QuizException;
    public QuizDTO getQuizResultById(Integer id) throws QuizException;
}

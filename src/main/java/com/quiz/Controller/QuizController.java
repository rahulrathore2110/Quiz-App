package com.quiz.Controller;

import com.quiz.DTO.QuizDTO;
import com.quiz.Exception.QuizException;
import com.quiz.Model.Quiz;
import com.quiz.Service.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {


    @Autowired
    private QuizService quizService;


    /**
     * create a quiz in the database, pass the quiz entity payload in json format.
     * @param quiz
     * @return get a quiz object which are created in the database.
     * @throws QuizException
     */
    @PostMapping
    public ResponseEntity<Quiz> createQuizHandler(@Valid @RequestBody Quiz quiz) throws QuizException {
        Quiz addVendor =  quizService.createQuiz(quiz);
        return new ResponseEntity<Quiz>(addVendor, HttpStatus.CREATED);
    }


    /**
     * Get list of quiz those are currently have active status and user can attempt these quizzes.
     * @return List of Quizzes those are in active state.
     * @throws QuizException
     */
    @GetMapping("/active")
    public ResponseEntity<List<Quiz>> getActiveQuizHandler() throws QuizException {
        List<Quiz> quizList =  quizService.getActiveQuiz();
        return new ResponseEntity<List<Quiz>>(quizList, HttpStatus.OK);
    }


    /**
     * Get the Quiz result using the quiz id that user attempt after the 5 min to successfully
     * completion of the quiz.
     * @param id
     * @return Controller return the QuizDTO object that contains the details about the quiz result.
     * @throws QuizException
     */
    @GetMapping("/{id}/result")
    public ResponseEntity<QuizDTO> getQuizResultByIdHandler(@PathVariable Integer id) throws QuizException {
        QuizDTO addVendor =  quizService.getQuizResultById(id);
        return new ResponseEntity<QuizDTO>(addVendor, HttpStatus.CREATED);
    }


    /**
     * Get the List of all quizzes have any type of status .
     * @return List of Quizzes.
     * @throws QuizException
     */
    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzesHandler() throws QuizException {
        List<Quiz> quizList =  quizService.getAllQuizzes();
        return new ResponseEntity<List<Quiz>>(quizList, HttpStatus.OK);
    }
}

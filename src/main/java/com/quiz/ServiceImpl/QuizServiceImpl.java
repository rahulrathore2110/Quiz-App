package com.quiz.ServiceImpl;

import com.quiz.DTO.QuizDTO;
import com.quiz.Exception.QuizException;
import com.quiz.Model.Quiz;
import com.quiz.Model.Status;
import com.quiz.Repository.QuizDao;
import com.quiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizDao quizDao;


    @Override
    public Quiz createQuiz(Quiz quiz) throws QuizException {
        /** Set the quiz status INACTIVE in initial stage.*/
        quiz.setStatus(Status.INACTIVE);

        /** save quiz entity to the database */
        return quizDao.save(quiz);
    }

    @Override
    public List<Quiz> getActiveQuiz() throws QuizException {
        /** get the list of all active quizzes from the database */
        List<Quiz> quizzes=quizDao.findActiveQuizzes();

        /** Check if any quiz are found aur not. if found return the list of quiz
         * otherwise throw an QuizException  */
        if(quizzes.isEmpty()){
            throw new QuizException("No Active Quiz Found At this moment");
        }

        return quizzes;
    }

    @Override
    public List<Quiz> getAllQuizzes() throws QuizException {
        /** Find the list of all quizzes present in the database  */
        List<Quiz> quizzes=quizDao.findAll();

        /** Check if any quiz are found aur not. if found return the list of quiz
         * otherwise throw an QuizException  */
        if(quizzes.isEmpty()){
            throw new QuizException("No Quiz Found At this moment");
        }

        return quizzes;
    }

    @Override
    public QuizDTO getQuizResultById(Integer id) throws QuizException {
        /** Find a quiz by id from the database. if quiz were found get the quiz object  from
         * optional object else throw an QuizException.  */
        Quiz quiz = quizDao.findById(id).orElseThrow(() -> new QuizException("No Quiz found with " +
                "this id : " + id));

        /** Get the minutes Duration between the quiz start and end timings */
        Long duration = Duration.between(quiz.getEndDate(), LocalDateTime.now()).toMinutes();

        /** if duration is greater than 5 Return the QuizDTO object as a result data to the user
         * because duration greater than 5 quiz mean quiz is finished else throw the exception to
         * user */
        if (duration > 5) {
            QuizDTO quizDTO = new QuizDTO(quiz.getDescription(), quiz.getOptions(),
                    quiz.getAnswer());

            return quizDTO;
        } else {
            throw new QuizException("Plz try after 5min of the quiz completion time end");
        }
    }
}

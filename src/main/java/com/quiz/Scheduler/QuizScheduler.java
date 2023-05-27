package com.quiz.Scheduler;

import com.quiz.Model.Quiz;
import com.quiz.Model.Status;
import com.quiz.Repository.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuizScheduler {

    @Autowired
    private QuizDao quizDao;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void quizStatusUpdate() {


        /** Get localDateTime to compare the quiz endTime to chane there status */
        LocalDateTime currentDateTime = LocalDateTime.now();


        /**
         Get the list of all quizzes from the database.
         filter out the list get the all quiz and compare start and End Date with currentDateTime.
         if currentDateTime is between these dated then it's status was ACTIVE.
         so store the active quiz in list of activeQuizzes variable
         */
        List<Quiz> activeQuizzes = quizDao.findAll()
                .stream()
                .filter(quiz -> quiz.getStartDate().isBefore(currentDateTime) && quiz.getEndDate().isAfter(currentDateTime))
                .collect(Collectors.toList());



        /**
         Get the list of all quizzes from the database.
         filter out the list get the all quiz and compare start Date with currentDateTime.
         if currentDateTime is above start date then it's status was INACTIVE.
         so store the INACTIVE quizzes in list of inactiveQuizzes variable
         */
        List<Quiz> inactiveQuizzes = quizDao.findAll()
                .stream()
                .filter(quiz -> quiz.getStartDate().isAfter(currentDateTime))
                .collect(Collectors.toList());



        /**
         Get the list of all quizzes from the database.
         filter out the list get the all quiz and compare end Date with currentDateTime.
         if currentDateTime is above end date then it's status was FINISHED.
         so store the finished quizzes in list of finishedQuizzes variable
         */
        List<Quiz> finishedQuizzes = quizDao.findAll()
                .stream()
                .filter(quiz -> quiz.getEndDate().isBefore(currentDateTime))
                .collect(Collectors.toList());



        /**
         First checking if inactiveQuizzes is empty or not.
         if not empty iterate the inactiveQuizzes and set the active status of each element of list.
         after that save the all list item to the database through JPA repository.
         */
        if (!inactiveQuizzes.isEmpty()) {
            inactiveQuizzes.forEach(quiz -> quiz.setStatus(Status.INACTIVE));
            quizDao.saveAll(inactiveQuizzes);
        }


        /**
         First checking if activeQuizzes is empty or not.
         if not empty iterate the activeQuizzes and set the active status of each element of list.
         after that save the all list item to the database through JPA repository.
         */
        if (!activeQuizzes.isEmpty()) {
            activeQuizzes.forEach(quiz -> quiz.setStatus(Status.ACTIVE));
            quizDao.saveAll(activeQuizzes);
        }



        /**
         First checking if finishedQuizzes is empty or not.
         if not empty iterate the finishedQuizzes and set the FINISHED status of each element of list.
         after that save the all list item to the database through JPA repository.
         */
        if (!finishedQuizzes.isEmpty()) {
            finishedQuizzes.forEach(quiz -> quiz.setStatus(Status.FINISHED));
            quizDao.saveAll(finishedQuizzes);
        }


    }
}
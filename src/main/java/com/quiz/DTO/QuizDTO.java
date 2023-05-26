package com.quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuizDTO {

    private String question;
    private List<String> options;
    private Integer answer;
}

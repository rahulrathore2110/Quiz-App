package com.quiz.DTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class QuizDTO {

    private String question;
    private List<String> options;
    private Integer answer;
}

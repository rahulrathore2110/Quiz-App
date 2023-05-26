package com.quiz.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class MyErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private  String detail;
}

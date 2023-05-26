package com.quiz.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer qid;

    @Column(nullable = false)
    @NotNull(message = "Description cannot be null")
    private String description;

    @ElementCollection
    @CollectionTable(name = "Quiz Options")
    @Column(nullable = false)
    @NotNull(message = "Options cannot be null")
    private List<String> options;

    @Column(nullable = false)
    @NotNull(message = "Answer cannot be null")
    private Integer answer;

    @Column(nullable = false)
    @NotNull(message = "StartDate cannot be null")
    private LocalDateTime startDate;

    @Column(nullable = false)
    @NotNull(message = "EndDate cannot be null")
    private LocalDateTime endDate;

    private Status status;
}

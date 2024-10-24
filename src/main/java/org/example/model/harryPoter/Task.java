package org.example.model.harryPoter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Task {
    private String name;
    private int difficulty;
    private int reward;
}

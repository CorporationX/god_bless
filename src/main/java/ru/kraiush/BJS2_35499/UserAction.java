package ru.kraiush.BJS2_35499;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    private int userId;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}

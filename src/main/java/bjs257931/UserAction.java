package bjs257931;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

}

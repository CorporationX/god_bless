package school.faang.task58032.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

}

package school.faang.bjs2_58148;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class UserAction {

    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

}

package school.faang.module1.bjs2_81044;

import lombok.Value;

import java.time.LocalDate;

@Value
public class UserAction {
    int id;
    String name;
    ActionType actionType;
    LocalDate actionDate;
    String content;
}
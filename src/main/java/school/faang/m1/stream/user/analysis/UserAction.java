package school.faang.m1.stream.user.analysis;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserAction {
    int userId;
    String userName;
    ActionType actionType;
    LocalDate actionDate;
    String content;
}

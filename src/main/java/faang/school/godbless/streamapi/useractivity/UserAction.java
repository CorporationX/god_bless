package faang.school.godbless.streamapi.useractivity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {
    private int userId;

    private String userName;

    private String actionType;

    private LocalDate actionDate;

    private String content;
}
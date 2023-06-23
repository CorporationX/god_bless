package faang.school.godbless.sprint3.streams.analysUsers.classes;

import faang.school.godbless.sprint3.streams.analysUsers.enums.ActionType;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate date;
    private String content;
}

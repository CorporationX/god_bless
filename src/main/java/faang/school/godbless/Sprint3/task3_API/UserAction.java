package faang.school.godbless.Sprint3.task3_API;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class UserAction {
    private int id;
    private String name;
    private String content;
    private ActionType actionType;
    private LocalDateTime actionDate;
}
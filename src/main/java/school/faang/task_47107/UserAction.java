package school.faang.task_47107;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}

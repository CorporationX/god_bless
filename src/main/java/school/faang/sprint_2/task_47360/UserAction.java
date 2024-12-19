package school.faang.sprint_2.task_47360;

import java.time.LocalDate;

public record UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {

}

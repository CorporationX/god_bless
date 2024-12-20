package school.faang.task_47319;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

public record UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {

}

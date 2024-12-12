package school.faang.task_47134;

import java.time.LocalDate;

public record UserAction(Integer id, String name, String actionType, LocalDate actionDate, String content) {}
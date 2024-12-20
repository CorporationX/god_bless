package school.faang.sprint_2.task_47307;

import java.time.LocalDate;

public record UserAction(int id, String name, ActionType type, LocalDate date, String content) {}

package school.faang.bjs270915;

import java.time.LocalDate;

public record UserAction(int id, String name, ActionType actions, LocalDate actionDate, String content) {}
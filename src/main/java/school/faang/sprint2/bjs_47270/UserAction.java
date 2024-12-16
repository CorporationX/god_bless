package school.faang.sprint2.bjs_47270;

import java.time.LocalDate;

public record UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {}

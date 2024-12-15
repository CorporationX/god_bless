package school.faang.sprint2.bjs_47270;

import java.time.LocalDate;

public record UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {}

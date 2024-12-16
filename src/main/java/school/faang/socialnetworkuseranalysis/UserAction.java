package school.faang.socialnetworkuseranalysis;

import java.time.LocalDate;

public record UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {}

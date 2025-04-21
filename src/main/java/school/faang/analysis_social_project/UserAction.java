package school.faang.analysis_social_project;

import java.time.LocalDate;

public record UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {
}

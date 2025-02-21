package useractionanalyzer;

import java.time.LocalDate;

public record UserAction(int userId, String userName, ActionType actionType, LocalDate actionDate, String content) {}


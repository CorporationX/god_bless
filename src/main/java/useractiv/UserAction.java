package useractiv;

import java.time.LocalDate;

public record UserAction(Integer id, String name, ActionType actionType, LocalDate actionDate, String content) {

}

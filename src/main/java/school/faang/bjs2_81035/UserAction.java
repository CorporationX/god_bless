package school.faang.bjs2_81035;

import java.time.LocalDate;

public record UserAction(Long id, String name, ActionType actionType, LocalDate actionDate, String content) {

}
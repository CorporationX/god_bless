package school.faang.user.activitiy;

import java.time.LocalDate;

public record UserAction(int id, String name, String actionType, LocalDate actionDate,
                         String content) {

}

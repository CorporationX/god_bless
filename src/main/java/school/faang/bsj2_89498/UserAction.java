package school.faang.bsj2_89498;

import java.time.LocalDate;

public record UserAction(int userId,
                         String userName,
                         Actions actionType,
                         LocalDate actionDate,
                         String content) {
}


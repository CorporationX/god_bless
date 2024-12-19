package school.faang.bjs47299;

import java.time.LocalDate;

public record UserAction(int userId, String userName, String type, LocalDate actionDate, String content) {
}

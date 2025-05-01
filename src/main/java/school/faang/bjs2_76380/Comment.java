package school.faang.bjs2_76380;

import java.time.LocalDateTime;

public record Comment(String text, User author, LocalDateTime timestamp) {
}

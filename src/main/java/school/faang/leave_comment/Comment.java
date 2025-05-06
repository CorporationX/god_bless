package school.faang.leave_comment;

import java.time.LocalDateTime;

public record Comment(int id, String text, String author, LocalDateTime dateTime) {

}

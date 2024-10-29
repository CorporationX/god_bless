package school.faang.comments;

import java.time.LocalDate;

public record Comment(String text, String author, LocalDate timestamp) {
}

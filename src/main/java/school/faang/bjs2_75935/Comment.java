package school.faang.bjs2_75935;

import java.time.LocalDateTime;
import java.util.function.Function;

public record Comment(String text, Author author, LocalDateTime timestamp) {
    public Comment {
        StringBuilder error = new StringBuilder();
        error = Utils.VALIDATE_TEXT.apply(text, "Text is empty");
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException();
        }
        ,author, timestamp);
    }
}

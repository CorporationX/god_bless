package school.faang.facebook;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime created = LocalDateTime.now();

    public boolean hasAuthor(String authorName) {
        return Objects.equals(this.author, authorName);
    }
}

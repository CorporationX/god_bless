package school.faang.sprint.fourth.facebookcomments;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.sql.Timestamp;


@Getter
@ToString
public class Comment {
    @NonNull
    private final String text;
    @NonNull
    private final String author;
    @NonNull
    private final Timestamp timestamp;

    public Comment(@NonNull String text, @NonNull String author, @NonNull Timestamp timestamp) {
        validate(text, author);
        this.text = text;
        this.author = author;
        this.timestamp = timestamp;
    }

    private void validate(String text, String author) {
        if (text.isBlank()) {
            throw new IllegalArgumentException("Text cannot be blank");
        }
        if (author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be blank");
        }
    }
}

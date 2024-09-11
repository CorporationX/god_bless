package faang.school.godbless.comment;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class Comment {
    private final String comment;
    private final Timestamp timestamp;

    public Comment(@NonNull String comment) {
        if (comment.isBlank()) {
            throw new IllegalArgumentException("Comment couldn't be empty");
        }

        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.comment = comment;
    }
}

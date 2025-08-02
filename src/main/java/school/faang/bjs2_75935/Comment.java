package school.faang.bjs2_75935;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Predicate;

@Getter
public class Comment {
    public static final String TEXT_IS_EMPTY = "Text is empty";
    public static final String AUTHOR_IS_EMPTY = "Author is empty";
    public static final String COMMENT_TIME_IS_EMPTY = "Comment time is empty";

    private final String text;
    private final Author author;
    private final LocalDateTime timestamp;

    public Comment(String text, Author author, LocalDateTime timestamp) {
        new ParamValidator()
            .addParam(Utils.VALIDATE_TEXT.test(text), TEXT_IS_EMPTY)
            .addParam(Utils.VALIDATE_OBJECT.test(author), AUTHOR_IS_EMPTY)
            .addParam(Utils.VALIDATE_OBJECT.test(timestamp), COMMENT_TIME_IS_EMPTY)
            .validate();

        this.text = text;
        this.author = author;
        this.timestamp = timestamp;
    }
}

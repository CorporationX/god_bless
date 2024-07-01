package faang.school.godbless.sprint2.comment;

import lombok.Getter;
import lombok.Setter;

import java.util.StringJoiner;

/**
 * @author Evgenii Malkov
 */
@Getter
public class Comment {
    @Setter
    long id;
    private final String text;
    private final long datetime;
    private final User author;

    public Comment(String text, long datetime, User author) {
        this.text = text;
        this.datetime = datetime;
        this.author = author;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Comment.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("author=" + author)
                .add("datetime=" + datetime)
                .toString();
    }
}

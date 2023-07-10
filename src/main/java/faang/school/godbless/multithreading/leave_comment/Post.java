package faang.school.godbless.multithreading.leave_comment;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Post {
    private final int id;
    private final String header;
    private final String text;
    private final Author author;
    private final List<Comment> comments;

    public Post(int id, String header, String text, Author author) {
        this.id = id;
        this.header = header;
        this.text = text;
        this.author = author;
        this.comments = new ArrayList<>();
    }
}

package faang.school.godbless.concurrency.task_1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
public class Post {
    @Setter
    private int postId = 0;
    private String header;
    private String text;
    private final User author;
    private volatile List<Comment> comments = new ArrayList<>();

    public Post(String header, String text, User author) {
        this.header = header;
        this.text = text;
        this.author = author;
    }
}

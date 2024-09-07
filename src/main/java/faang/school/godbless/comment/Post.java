package faang.school.godbless.comment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Post {
    private static int idCounter = 0;
    private final int id;
    private final String title;
    private final String text;
    private final String author;
    private final List<Comment> comments;

    public Post(String title, String text, String author) {
        this.id = idCounter++;
        this.title = title;
        this.text = text;
        this.author = author;
        this.comments = new ArrayList<>();
    }
}

package school.faang.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private final List<Comment> comments;

    public Post(int id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
    }
}

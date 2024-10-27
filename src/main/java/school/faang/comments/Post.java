package school.faang.comments;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Post {
    private static int currentId = 0;

    private int id;
    private String title;
    private String content;
    private int authorId;
    private List<Comment> comments = new ArrayList<>();

    public Post(String title, String content, int authorId) {
        this.id = ++currentId;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
    }
}

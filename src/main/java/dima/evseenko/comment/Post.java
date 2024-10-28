package dima.evseenko.comment;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Post {
    private final int id;
    private final String author;
    private final Map<Integer, Comment> comments = new HashMap<>();

    private String title;
    private String content;

    public Post(int id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }
}

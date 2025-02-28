package bjs2_62563;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments = new ArrayList<>();

    public Post(int id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

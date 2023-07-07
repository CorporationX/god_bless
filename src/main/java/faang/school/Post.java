package faang.school;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Post {
    private static int ID_GENERATOR = 1;
    private int id;
    private String title;
    private String text;
    private String author;
    private List<Comment> comments = new ArrayList<>();

    public Post(String title, String text, String author) {
        this.title = title;
        this.text = text;
        this.author = author;
        id = ID_GENERATOR++;
    }

    public synchronized void addComment(Comment comment) {
        comments.add(comment);
    }
}

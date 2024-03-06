package faang.school.godbless.comments;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Post {
    private int id;
    private String header;
    private String text;
    private String author;
    private List<Comment> comments = new ArrayList<>();

    public Post(int id, String header, String text, String author) {
        this.id = id;
        this.header = header;
        this.text = text;
        this.author = author;
    }

    public void deleteComment(Comment comment) {
        comments.remove(comment);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

}

package faang.school.godbless.facebook;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
public class Post {
    private int id;
    private String title;
    private String text;
    private String author;
    private final List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment, String userName) {
        if(comment.getAuthor().equals(userName)) {
            comments.remove(comment);
        }
    }

    public Post(int id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }
}

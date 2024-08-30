package faang.school.godbless.BJS2_25530;

import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Getter
@ToString
public class Post {
    private String title;
    private String text;
    private List<Comment> comments = new LinkedList<>();

    public Post(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public synchronized void addComment(Comment comment) {
        comments.add(comment);
    }
}

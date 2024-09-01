package faang.school.godbless.BJS2_25429;

import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@ToString
@Getter
public class Post {
    private final String title;
    private final String text;
    private final List<Comment> comments = new LinkedList<>();

    public Post(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public synchronized void addComment(Comment comment) {
        comments.add(comment);
    }
}

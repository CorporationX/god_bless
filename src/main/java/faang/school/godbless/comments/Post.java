package faang.school.godbless.comments;

import lombok.Getter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Post implements Comparable {
    private static int curId = 0;
    private final Integer id;
    private final String title;
    private final String body;
    private final String author;
    private final List<Comment> comments;

    public Post(String title, String body) {
        id = ++CUR_ID;
        this.title = title;
        this.body = body;
        this.author = Thread.currentThread().getName();
        this.comments = new CopyOnWriteArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void deleteComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public int compareTo(Object o) {
        return this.id - ((Post) o).id;
    }
}

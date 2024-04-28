package faang.school.godbless.BJS2_6189;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Post {
    private int id;
    private String title;
    private String text;
    private String author;
    private List<Comment> comments;
    private ReentrantLock lock;

    public Post(int id, String title, String text, String author) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.author = author;
        this.comments = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

    public void addComment(Comment comment) {
        if (comment != null) {
            lock.lock();
            comments.add(comment);
            lock.unlock();
        }
    }

    public void deleteComment(Comment comment) {
        if (comment != null) {
            lock.lock();
            comments.remove(comment);
            lock.unlock();
        }
    }
}

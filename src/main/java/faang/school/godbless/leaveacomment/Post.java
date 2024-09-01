package faang.school.godbless.leaveacomment;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@ToString
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments;
    private final Lock lock;

    public Post(int id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = new CopyOnWriteArrayList<>();
        this.lock = new ReentrantLock();
    }

    public void addComment(Comment comment) {
        lock.lock();
        try {
            comments.add(comment);
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(Comment comment) {
        lock.lock();
        try {
            comments.remove(comment);
        } finally {
            lock.unlock();
        }
    }
}
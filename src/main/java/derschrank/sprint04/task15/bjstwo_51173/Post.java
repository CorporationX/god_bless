package derschrank.sprint04.task15.bjstwo_51173;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@EqualsAndHashCode
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final Author author;
    private final List<Comment> comments;
    private final Lock lock;

    public Post(int id, String title, String content, Author author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        comments = new ArrayList<>();
        lock = new ReentrantLock();
    }

    public void addComment(Comment comment) {
        lock.lock();
        try {
            comments.add(comment);
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(Comment comment, Author author) {
        if (author.equals(comment.author())) {
            lock.lock();
            try {
                comments.remove(comment);
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                '}';
    }
}

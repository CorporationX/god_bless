package school.faang.facebook;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Data
public class Post {
    @Getter
    private final int id;
    @Getter
    private final String title;
    @Getter
    private final String content;
    @Getter
    private final String author;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        lock.writeLock().lock();
        try {
            comments.add(comment);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<Comment> getComments() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(comments);
        } finally {
            lock.readLock().unlock();
        }
    }

    public boolean removeComment(Comment comment, String requester) {
        lock.writeLock().lock();
        try {
            if (comment.hasAuthor(requester)) {
                return comments.remove(comment);
            }
            return false;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean hasAuthor(String authorName) {
        return Objects.equals(this.author, authorName);
    }
}

package school.faang.m1.concurrency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private final int id;
    private final String title;
    private final String content;
    private final String author;

    private final List<Comment> comments = new ArrayList<>();
    private final ReentrantReadWriteLock commentsLock = new ReentrantReadWriteLock();

    public void addComment(Comment c) {
        var w = commentsLock.writeLock();
        w.lock();
        try {
            comments.add(c);
        } finally {
            w.unlock();
        }
    }

    public List<Comment> getCommentsSnapshot() {
        var r = commentsLock.readLock();
        r.lock();
        try {
            return List.copyOf(comments);
        } finally {
            r.unlock();
        }
    }

    /**
     * Удаление комментария разрешено только его автору.
     * Для простоты идентифицируем комментарий по (timestamp, author, text).
     * Возвращает true, если удалён.
     */

    public boolean deleteComment(String requestor, LocalDateTime timeStamp, String text) {
        var w = commentsLock.writeLock();
        w.lock();
        try {
            Iterator<Comment> it = comments.iterator();
            while (it.hasNext()) {
                Comment c = it.next();
                if (c.getTimestamp().equals(timeStamp) && c.getText().equals(text) && c.getAuthor().equals(requestor)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        } finally {
            w.unlock();
        }
    }

    @Override
    public String toString() {
        return "Post#" + id + " [" + title + "] by " + author;
    }
}
package faang.school.godbless.leave_a_comment;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class Post {
    private static int startId = 0;
    private int id;
    private String header;
    private String content;
    private User author;
    private Map<Integer, Comment> comments;
    private ReentrantLock reentrantLock;

    public Post(String header, String content, User author) {
        this.id = startId++;
        this.header = header;
        this.content = content;
        this.author = author;
        this.comments = new HashMap<>();
        this.reentrantLock = new ReentrantLock();
    }

    public void addComment(Comment comment) {
        reentrantLock.lock();
        comments.put(comment.getId(), comment);
        reentrantLock.unlock();
    }

    public void deleteComment(Comment comment) {
        reentrantLock.lock();
        comments.remove(comment.getId());
        reentrantLock.unlock();
    }
}

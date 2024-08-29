package faang.school.godbless.task.multithreading.async.leave.comment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Getter
@ToString
@RequiredArgsConstructor
public class Post {
    private final User author;
    private final String header;
    private final String content;
    private static final AtomicLong idCounter = new AtomicLong();
    private final long id = idCounter.incrementAndGet();
    private final Map<Long, Comment> comments = new ConcurrentHashMap<>();
    private final Lock postLock = new ReentrantLock();

    public void addComment(Comment comment) {
        log.info("{} add comment to post with id: {}", comment.getAuthor().getName(), this.id);
        comments.put(comment.getId(), comment);
    }

    public void deleteComment(User user, long commentId) {
        log.info("{} deleted comment with id: {}", user.getName(), commentId);
        if (comments.containsKey(commentId) && isAuthor(user, commentId)) {
            comments.remove(commentId);
        }
    }

    private boolean isAuthor(User user, long commentId) {
        return comments.get(commentId).getAuthor().equals(user);
    }
}

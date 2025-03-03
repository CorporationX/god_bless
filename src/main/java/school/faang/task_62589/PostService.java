package school.faang.task_62589;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@EqualsAndHashCode
@Slf4j
public class PostService {
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void addPost(Post post) {
        lock.writeLock().lock();
        try {
            posts.put(post.getId(), post);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.writeLock().lock();
        try {
            Post post = posts.get(postId);
            if (post != null) {
                post.addComment(comment);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void deletePost(int postId, String author) {
        lock.writeLock().lock();
        try {
            posts.computeIfPresent(postId, (id, post) ->
                    post.getAuthor().equals(author) ? null : post);
            log.info(String.format("Post author: %s delete%n", author));
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void deleteComment(int postId, LocalDateTime localDateTime, String author) {
        lock.writeLock().lock();
        try {
            Post post = posts.get(postId);
            if (post != null) {
                post.getComments().entrySet()
                        .removeIf(entry ->
                                entry.getKey().equals(localDateTime) && entry.getValue().getAuthor().equals(author));
            }
            log.info(String.format("Comment author: %s delete%n", author));
        } finally {
            lock.writeLock().unlock();
        }
    }
}

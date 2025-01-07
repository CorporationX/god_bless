package school.faang.task_51263;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class PostService {
    private final Map<Integer, Post> postById;
    private final ReadWriteLock postByIdLock;

    public PostService() {
        this.postById = new HashMap<>();
        this.postByIdLock = new ReentrantReadWriteLock();
    }

    public void addPost(@NonNull Post post) {
        postByIdLock.writeLock().lock();
        try {
            postById.put(post.getId(), post);
            log.info("Post added: ID={}, Title='{}'", post.getId(), post.getTitle());
        } finally {
            postByIdLock.writeLock().unlock();
        }
    }

    public void addComment(int postId, @NonNull Comment comment) {
        postByIdLock.readLock().lock();
        try {
            Post post = postById.get(postId);
            if (post != null) {
                post.addComment(comment);
                log.info("Comment added to Post ID={} by Author='{}'", postId, comment.author());
            } else {
                logPostNotFound(postId);
            }
        } finally {
            postByIdLock.readLock().unlock();
        }
    }

    public void deletePost(int postId, @NonNull String author) {
        postByIdLock.writeLock().lock();
        try {
            Post post = postById.get(postId);
            if (post != null) {
                if (author.equals(post.getAuthor())) {
                    postById.remove(postId);
                    log.info("Post deleted: ID={}, Title='{}'", postId, post.getTitle());
                } else {
                    log.warn("Authors do not match: Attempted by '{}' but the author is '{}'",
                            author, post.getAuthor());
                }
            } else {
                logPostNotFound(postId);
            }
        } finally {
            postByIdLock.writeLock().unlock();
        }
    }

    public void deleteComment(int postId, @NonNull LocalDateTime timestamp, @NonNull String author) {
        postByIdLock.readLock().lock();
        try {
            Post post = postById.get(postId);
            if (post != null) {
                post.deleteComment(timestamp, author);
            } else {
                logPostNotFound(postId);
            }
        } finally {
            postByIdLock.readLock().unlock();
        }
    }

    private void logPostNotFound(int postId) {
        log.warn("Post not found for ID={}", postId);
    }

}

package school.faang.bjs251284;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@Getter
public class PostService {

    private List<Post> posts = Collections.synchronizedList(new ArrayList<>());
    private Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            log.info("Post added: {}", post.getTitle());
        } catch (Exception e) {
            log.error("Failed to add post: {}", e.getMessage(), e);
            throw e;
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            if (comment == null) {
                log.error("Attempted to add a null comment to post ID: {}", postId);
                throw new IllegalArgumentException("Comment cannot be null");
            }
            posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst()
                    .ifPresentOrElse(post -> {
                                post.addComment(comment);
                                log.info("Comment added successfully to post ID {}: {}", postId, comment.getText());
                            },
                            () -> log.error("Post not found with ID: {}", postId)
                    );
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(int postId) {
        lock.lock();
        try {
            if (postId <= 0) {
                log.error("Invalid post ID in deletePost Method: {}", postId);
                throw new IllegalArgumentException("Post ID in deletePost Method must be greater than 0");
            }
            posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst()
                    .ifPresentOrElse(post -> {
                        posts.remove(post);
                        log.info("Post removed with ID: {} by author: {}", postId, post.getAuthor());
                    }, () -> log.error("Post not found with ID in deletePost Method: {}", postId));
        } catch (Exception e) {
            log.error("Failed to delete post with ID: {}", postId, e);
            throw e;
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, String author) {
        lock.lock();
        try {
            if (postId <= 0) {
                log.error("Invalid post ID in deleteComment method: {}", postId);
                throw new IllegalArgumentException("Post ID must be greater than 0 in deleteComment method");
            }
            posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst()
                    .ifPresentOrElse(post -> {
                        boolean removed = post.getComments().removeIf(comment ->
                                comment.getAuthor().equals(author));
                        if (removed) {
                            log.info("Comment by {} removed from post ID {} with title: {}",
                                    author, postId, post.getTitle());
                        } else {
                            log.warn("No comment by {} found in post ID {} with title: {}",
                                    author, postId, post.getTitle());
                        }
                    }, () -> log.error("Post not found with ID {} in deleteComment method", postId));
        } catch (Exception e) {
            log.error("Failed to delete comment by {} from post ID {}: {}", author, postId, e.getMessage(), e);
            throw e;
        } finally {
            lock.unlock();
        }
    }
}

package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            if (!posts.contains(post)) {
                posts.add(post);
                log.info("Post with id {} added to post service.", post.id());
            } else {
                log.warn("Post with id {} is already added to post service.", post.id());
            }
        } finally {
            lock.unlock();
        }
    }

    public void removePost(Post post) {
        lock.lock();
        try {
            if (posts.contains(post)) {
                posts.remove(post);
                log.info("Post with id {} removed from post service.", post.id());
            } else {
                log.warn("No post with id {} in post service.", post.id());
            }
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.id() == postId) {
                    if (post.comments().contains(comment)) {
                        log.warn("The post with id {} is already contains a comment by {} at {}.",
                                postId, comment.author(), comment.timestamp());
                    } else {
                        post.comments().add(comment);
                        log.info("A comment by {} at {} added to post service.", comment.author(), comment.timestamp());
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(int postId, String author, LocalDateTime timestamp) {
        lock.lock();
        try {
            posts.stream()
                    .filter(post -> post.id() == postId)
                    .findFirst()
                    .ifPresent(post -> {
                        if (post.comments().removeIf(comment -> comment.timestamp().equals(timestamp)
                                && comment.author().equals(author))) {
                            log.info("Post with id {} and author {} was removed from post service.", postId, author);
                        } else {
                            log.info("No post found with id {} and author {} in post service.", postId, author);
                        }
                    });
        } finally {
            lock.unlock();
        }
    }
}
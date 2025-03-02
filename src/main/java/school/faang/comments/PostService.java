package school.faang.comments;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private static final List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        actionsWithPost(() -> {
            posts.add(post);
            log.info("Added post: {}", post);
        });
    }

    public void addComment(int postId, Comment comment) {
        actionsWithPost(() -> {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.addComment(comment);
                    log.info("comment {} added to post with id {}", comment, postId);
                    return;
                }
            }
            log.info("post with id {} is not found", postId);

        });
    }

    public void removeComment(int postId, LocalDateTime timestamp, String author) {
        actionsWithPost(() -> {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    List<Comment> comments = post.getComments();
                    if (comments.removeIf(comment ->
                            comment.getTimestamp().equals(timestamp)
                                    && comment.getAuthor().equals(author))) {
                        log.info("comments with author {} is removed from post with id {}", author, postId);
                        return;
                    }
                    log.info("comments with author {} is not found", author);
                    return;
                }
            }
            log.info("post with id {} is not found", postId);
        });
    }

    public void removePost(int postId,  String author) {
        actionsWithPost(() -> {
            boolean removed = posts.removeIf(post -> post.getId() == postId
                    && post.getAuthor().equals(author));
            log.info(removed ? "removed post with id {}" : "post with id {} not found", postId);
        });
    }

    public void showPosts() {
        actionsWithPost(() -> {
            for (Post post : posts) {
                log.info(post.toString());
            }
        });
    }

    private void actionsWithPost(Runnable action) {
        lock.lock();
        try {
            action.run();
        } finally {
            lock.unlock();
        }
    }
}

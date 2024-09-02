package faang.school.godbless.LeaveComment;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Object lock = new Object();

    public void  addComment(Comment comment, String postId) {
        synchronized (lock) {
            posts.stream()
                    .filter(p -> p.getId().equals(postId))
                    .findFirst()
                    .ifPresent(p -> {
                        p.addComment(comment);
                        log.info("Comment '{}' added to post '{}'", comment.getText(), p.getTitle());
                    });
        }
    }

    public void removeComment(String commentId, String postId) {
        synchronized (lock) {
            posts.stream()
                    .filter(p -> p.getId().equals(postId))
                    .findFirst()
                    .ifPresent(p -> {
                        p.removeComment(commentId);
                        log.info("Removed comment '{}' from '{}'", commentId, p.getTitle());
                    });
        }
    }

    public void addPost(Post post) {
        synchronized (lock) {
            posts.add(post);
            log.info("Added post '{}'", post.getTitle());
        }
    }

    public void removePost(String postId) {
        synchronized (lock) {
            posts.removeIf(post -> {
                if (post.getId().equals(postId)) {
                    log.info("Removed post '{}'", post.getTitle());
                    return true;
                } else {
                    return false;
                }
            });
        }
    }

    public List<Post> getPosts() {
        synchronized (lock) {
            return new ArrayList<>(posts);
        }
    }
}

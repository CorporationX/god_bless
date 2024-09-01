package faang.school.godbless.BJS2_25304;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Getter
public class PostService {
    private volatile List<Post> posts = new ArrayList<>();
    private static final Object LOCKER_POSTS = new Object();

    public void addComment(Comment comment, int id) {
        synchronized (LOCKER_POSTS) {
            Post post = findPostById(id);

            if (post == null) {
                throw new IllegalArgumentException("Post with id " + id + " doesn't exist");
            } else {
                synchronized (post) {
                    post.addComment(comment);
                }
            }
        }
    }

    public void addPost(Post post) {
        synchronized (LOCKER_POSTS) {
            posts.add(post);
        }
    }

    public void deletePost(int id) {
        synchronized (LOCKER_POSTS) {
            posts.removeIf(post -> {
                if (post.id() == id && post.author().equals(Thread.currentThread().getName())) {
                    log.info("Post written by {} with id {} was deleted by {}", post.author(), id, Thread.currentThread().getName());
                    return true;
                } else {
                    log.info("{} is not author of id {}, need {}", Thread.currentThread().getName(), id, post.author());
                    return false;
                }
            });
        }
    }

    public void deleteComments(int postId) {
        Post post;
        synchronized (LOCKER_POSTS) {
            post = findPostById(postId);
        }

        if (post == null) {
            log.error("Post with id {} does not exist", postId);
            return;
        }

        synchronized (post) {
            Optional<Comment> commentToDelete = post.comments()
                    .stream()
                    .filter(comment -> comment.author().equals(Thread.currentThread().getName()))
                    .findFirst();

            if (commentToDelete.isPresent()) {
                log.info("Comment with author {} was deleted by author {}", commentToDelete.get().author(),
                        Thread.currentThread().getName());
                post.comments().remove(commentToDelete.get());
            }
        }
    }

    private Post findPostById(int id) {
        return posts.stream()
                .filter(post -> post.id() == id)
                .findFirst()
                .orElse(null);
    }
}

package faang.school.godbless.multithreading_concurrency.task_1;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class PostService {
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private static final int ACTION_DURATION = 1000;

    public void addComment(int postId, Comment comment) {
        try {
            Thread.sleep(ACTION_DURATION);
            final Post post = posts.get(postId);
            if (post != null) {
                post.getComments().add(comment);
            } else {
                log.error("Post with ID {} not found. Unable to add comment.", postId);
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted while adding comment to post ID {}", postId, e);
            Thread.currentThread().interrupt();
        }
    }

    public void deleteComment(int postId, Comment comment) {
        try {
            Thread.sleep(ACTION_DURATION);
            final Post post = posts.get(postId);
            if (post == null) {
                log.error("Post with ID {} not found. Unable to delete comment ID {}", postId,
                    comment.getId());
            } else {
                final List<Comment> comments = post.getComments();
                if (!comments.contains(comment)) {
                    log.error("Post with ID {} doesn't have comment. Unable to delete comment ID {}",
                        postId, comment.getId());
                } else {
                    comments.remove(comment);
                }
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted while deleting comment ID {} from post ID {}",
                comment.getId(), postId, e);
            Thread.currentThread().interrupt();
        }
    }

    public Optional<List<Comment>> getComments(int postId) {
        try {
            Thread.sleep(ACTION_DURATION);
            final Post post = posts.get(postId);
            if (post == null) {
                log.error("Post with ID {} not found. Unable to get comments", postId);
                return Optional.empty();
            } else {
                return Optional.ofNullable(post.getComments());
            }
        } catch (InterruptedException e) {
            log.error("Thread was interrupted while getting comments from post ID {}", postId, e);
            Thread.currentThread().interrupt();
            return Optional.empty();
        }
    }

    public void addPost(Post post) {
        try {
            Thread.sleep(ACTION_DURATION);
            posts.put(post.getId(), post);
        } catch (InterruptedException e) {
            log.error("Thread interrupted while adding post ID {}", post.getId(), e);
            Thread.currentThread().interrupt();
        }
    }

    public void deletePost(int postId) {
        try {
            Thread.sleep(ACTION_DURATION);
            if (posts.containsKey(postId)) {
                posts.remove(postId);
            } else {
                log.error("Post with ID {} not found. Unable to delete post.", postId);
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted while deleting post ID {}", postId, e);
            Thread.currentThread().interrupt();
        }
    }

    public Optional<Post> getPost(int postId) {
        try {
            Thread.sleep(ACTION_DURATION);
            final Post post = posts.get(postId);
            if (post != null) {
                return Optional.ofNullable(posts.get(postId));
            } else {
                log.error("Post with ID {} doesn't exist", postId);
                return Optional.empty();
            }
        } catch (InterruptedException e) {
            log.error("Thread was interrupted while getting post ID {}", postId, e);
            Thread.currentThread().interrupt();
            return Optional.empty();
        }
    }
}

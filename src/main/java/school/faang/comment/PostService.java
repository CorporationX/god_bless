package school.faang.comment;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class PostService {
    private final List<Post> posts = new ArrayList<>();

    public synchronized void addPost(Post post) {
        log.debug("Thread: {} executing addPost", Thread.currentThread().getName());
        Objects.requireNonNull(post);
        this.posts.add(post);
        log.debug("Thread: {} post added", Thread.currentThread().getName());
    }

    public synchronized void addComment(int postId, Comment comment) {
        log.debug("Thread: {} executing addComment for post by id {}", Thread.currentThread().getName(), postId);
        Objects.requireNonNull(comment);
        Post postById = getPostById(postId);
        postById.getComments().add(comment);
        log.debug("Thread: {} comment added", Thread.currentThread().getName());
    }

    public synchronized void deletePost(int postId, String requestAuthor) {
        log.debug("Thread: {} executing delete post by id {}", Thread.currentThread().getName(), postId);
        Post postById = getPostById(postId);
        checkIfPostAuthor(postById, requestAuthor);
        boolean isPostRemoved = posts.remove(postById);
        if (isPostRemoved) {
            log.debug("Thread: {} post with id {} was removed", Thread.currentThread().getName(), postId);
        }
    }

    public synchronized void deleteComment(int postId, int commentId, String requestAuthor) {
        log.debug("Thread: {} executing delete comment for post by id {}", Thread.currentThread().getName(), postId);
        Post postById = getPostById(postId);
        Comment commentById = getCommentById(postById, commentId);
        checkIfCommentAuthor(commentById, requestAuthor);
        boolean isCommentRemoved = postById.getComments().remove(commentById);
        if (isCommentRemoved) {
            log.debug("Thread: {} comment with id {} was removed", Thread.currentThread().getName(), commentId);
        }
    }

    private Post getPostById(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("No post found with id %d", postId)));
    }

    private Comment getCommentById(Post postById, int commentId) {
        return postById.getComments().stream()
                .filter(comment -> comment.getId() == commentId)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
    }

    private void checkIfPostAuthor(Post postById, String requestAuthor) {
        if (!Objects.equals(postById.getAuthor(), requestAuthor)) {
            throw new IllegalArgumentException("Only author can delete this post");
        }
    }

    private void checkIfCommentAuthor(Comment commentById, String requestAuthor) {
        if (!Objects.equals(commentById.getAuthor(), requestAuthor)) {
            throw new IllegalArgumentException("Only author can delete this comment");
        }
    }
}

package faang.school.godbless.leavecomments;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {

    private HashMap<Long, Post> posts = new HashMap<>();

    private final ReentrantLock LOCK = new ReentrantLock();

    public void addComment(long postId, Comment comment) {
        validatePostNotExists(postId);
        LOCK.lock();
        try {
            posts.get(postId).addCommentary(comment);
        } finally {
            LOCK.unlock();
        }
    }

    public void addPost(Post post) {
        long postId = post.getId();
        validatePostExists(postId);
        LOCK.lock();
        try {
            posts.put(postId, post);
        } finally {
            LOCK.unlock();
        }
    }

    public Optional<Post> getPostById(long postId) {
        return Optional.ofNullable(posts.get(postId));
    }

    public void deletePost(long postId, String author) {
        validatePostEditing(postId, author);
        LOCK.lock();
        try {
            posts.remove(postId);
        } finally {
            LOCK.unlock();
        }
    }

    public void deleteComment(long postId, Comment comment, String author) {
        validateCommentEditing(postId, comment, author);
        LOCK.lock();
        try {
            posts.get(postId).getComments().remove(comment);
        } finally {
            LOCK.unlock();
        }
    }

    private void validatePostNotExists(long postId) {
        if (!posts.containsKey(postId)) {
            throw new IllegalArgumentException("Post doesn't exist");
        }
    }

    private void validatePostExists(long postId) {
        if (posts.containsKey(postId)) {
            throw new IllegalArgumentException("Post already exist");
        }
    }

    private void validatePostEditing(long postId, String author) {
        validatePostNotExists(postId);
        if (!author.equals(posts.get(postId).getAuthor())) {
            throw new IllegalArgumentException("Edit post able only for post author");
        }
    }

    private void validateCommentEditing(long postId, Comment comment, String author) {
        validatePostNotExists(postId);
        if (!posts.get(postId).getComments().contains(comment)) {
            throw new IllegalArgumentException("Comment does not exist");
        }
        if (!author.equals(comment.getAuthor())) {
            throw new IllegalArgumentException("Edit comment able only for comment author");
        }
    }
}

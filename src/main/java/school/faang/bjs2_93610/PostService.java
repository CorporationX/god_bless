package school.faang.bjs2_93610;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private volatile Map<Integer, Post> posts = new HashMap<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        if (post == null) {
            log.error("post cannot be null");
            return;
        }
        lock.lock();
        try {
            posts.put(post.getId(), post);
            log.info("post add{} :", post.getTitle());
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        if (comment == null) {
            log.error("comment cannot be null");
            return;
        }

        lock.lock();
        try {
            Post post = posts.get(postId);
            if (post != null) {
                post.addComment(comment);
                log.info("comments add{} : , Post ID:{}, Author: {}", comment, postId, comment.getAuthor());
            } else {
                log.error("Post with ID {} not fount", postId);
            }
        } finally {
            lock.unlock();
        }
    }

    public void viewComments(int postId) {
        Post post = posts.get(postId);
        if (post != null) {
            post.getComments().forEach(comment ->
                    System.out.printf("Author: %s, Text: %s, Time: %s%n",
                            comment.getAuthor(), comment.getText(), comment.getTimestamp()));
        }
    }

    public void viewPost(int postId) {
        Post post = posts.get(postId);
        if (post != null) {
            System.out.printf("Title: %s%nContent: %s%nAuthor: %s%n",
                    post.getTitle(), post.getContent(), post.getAuthor());
        }
    }

    public boolean deleteComment(int postId, Comment commentForDelete, String requester) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            if (post != null) {
                boolean removed = post.removeComment(commentForDelete, requester);
                if (removed) {
                    log.info("Comment deleted: {}, Post ID: {}", commentForDelete.getText(), postId);
                } else {
                    log.warn("Failed to delete comment - unauthorized or not found");
                }
                return removed;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public boolean deletePost(int postId, String requester) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            if (post != null && post.getAuthor().equals(requester)) {
                posts.remove(postId);
                log.info("Post deleted, ID: {}", postId);
                return true;
            }
            log.warn("Unauthorized deletion attempt for post ID: {}", postId);
            return false;
        } finally {
            lock.unlock();
        }
    }
}

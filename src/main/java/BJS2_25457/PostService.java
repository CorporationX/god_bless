package BJS2_25457;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Post post = posts.stream()
                    .filter(p -> p.getId() == postId)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Post not found"));
            post.getComments().add(comment);
        } finally {
            lock.unlock();
        }
    }

    public List<Post> viewPosts() {
        lock.lock();
        try {
            return new ArrayList<>(posts);
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(int postId, String author) {
        lock.lock();
        try {
            posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(author));
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, String author, LocalDateTime commentTime) {
        lock.lock();
        try {
            Post post = posts.stream()
                    .filter(p -> p.getId() == postId)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Post not found"));
            post.getComments().removeIf(comment -> comment.getAuthor().equals(author) && comment.getDateTime().equals(commentTime));
        } finally {
            lock.unlock();
        }
    }
}

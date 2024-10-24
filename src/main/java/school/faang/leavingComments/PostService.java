package school.faang.leavingComments;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final List<Post> posts = Post.generatePosts();
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
            posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst()
                    .ifPresent(post -> post.getComments().add(comment));
        } finally {
            lock.unlock();
        }
    }

    public void viewPost(int postId) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    System.out.println(post.formatPost());
                    post.getComments().forEach(
                            comment -> System.out.println(comment.formatComment()));
                }
            }
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

    public void deleteComment(int postId, LocalDateTime timestamp, String author) {
        lock.lock();
        try {
            posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst()
                    .ifPresent(post -> post.getComments().removeIf(
                            comment -> comment.getTimestamp() == timestamp && comment.getAuthor().equals(author)));
        } finally {
            lock.unlock();
        }
    }
}

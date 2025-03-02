package school.faang.task_62589;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
            posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst()
                    .ifPresent(post -> post.addComment(comment));
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(int postId, String author) {
        lock.lock();
        try {
            posts.removeIf(post ->
                    post.getId() == postId && author.equals(post.getAuthor()));
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, LocalDateTime localDateTime, String author) {
        lock.lock();
        try {
            posts.stream()
                    .filter(post -> post.getId() == postId)
                    .forEach(post -> post.getComments()
                            .removeIf(comment -> comment.getTimestamp().equals(localDateTime)
                                    && comment.getAuthor().equals(author)));
        } finally {
            lock.unlock();
        }
    }
}

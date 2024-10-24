package school.faang.leavecomment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
            Optional<Post> postOptional = posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst();
            postOptional.ifPresent(post -> post.addComment(comment));
        } finally {
            lock.unlock();
        }
    }

    public List<Post> getPosts() {
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

    public void deleteComment(int postId, String author, LocalDateTime timestamp) {
        lock.lock();
        try {
            Optional<Post> postOptional = posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst();
            postOptional.ifPresent(post -> post.getComments().removeIf(comment ->
                    comment.getAuthor().equals(author) && comment.getTimestamp().equals(timestamp)));
        } finally {
            lock.unlock();
        }
    }
}

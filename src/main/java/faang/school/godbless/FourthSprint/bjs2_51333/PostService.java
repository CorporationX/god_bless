package faang.school.godbless.FourthSprint.bjs2_51333;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


@Getter
public class PostService {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private volatile List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        lock.writeLock().lock();
        try {
            if (!posts.contains(post)) {
                posts.add(post);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.writeLock().lock();
        try {
            getPost(postId).getComments().add(comment);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void deletePost(int postId, User author) {
        lock.writeLock().lock();
        try {
            Post post = getPost(postId);
            if (post.getAuthor().equals(author)) {
                posts.remove(post);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void deleteComment(int postId, User author, LocalDateTime timestamp) {
        lock.writeLock().lock();
        try {
            Post post = getPost(postId);
            post.getComments().remove(getComment(postId, author, timestamp));
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Post getPost(int postId) {
        lock.readLock().lock();
        Post post = null;
        try {
            post = posts.stream()
                    .filter(n -> n.getId() == postId)
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("This post doesn't exist!"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.readLock().unlock();
        }
        return post;
    }

    public Comment getComment(int postId, User author, LocalDateTime timestamp) {
        lock.readLock().lock();
        Comment comment = null;
        try {
            Post post = getPost(postId);
            comment = post.getComments()
                    .stream()
                    .filter(c -> c.getAuthor().equals(author) && c.getTimestamp().equals(timestamp))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("This comment doesn't exist"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            lock.readLock().unlock();
        }
        return comment;
    }
}

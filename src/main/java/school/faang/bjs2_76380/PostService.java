package school.faang.bjs2_76380;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
public class PostService {
    private final Map<Long, Post> posts = new ConcurrentHashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void addPost(Post post) {
        lock.writeLock().lock();
        try {
            Post existing = posts.putIfAbsent(post.id(), post);
            if (existing != null) {
                throw new PostAlreadyExistsException(post.id());
            }
            log.info("Added new post {}", post.title());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void addComment(long postId, Comment comment) {
        lock.writeLock().lock();
        try {
            Post post = getPostById(postId);
            post.comments().add(comment);
            log.info("Added new comment in post {}", post.title());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public List<Post> getAllPosts() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(posts.values());
        } finally {
            lock.readLock().unlock();
        }
    }

    public List<Comment> getComments(long postId) {
        lock.readLock().lock();
        try {
            Post post = getPostById(postId);
            return new ArrayList<>(post.comments());
        } finally {
            lock.readLock().unlock();
        }
    }

    public void deletePost(long postId, User user) {
        lock.writeLock().lock();
        try {
            Post post = getPostById(postId);
            checkPermission(post, user);
            posts.remove(postId);
            log.info("Delete post {}", post.title());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void deleteComment(long postId, Comment comment, User user) {
        lock.writeLock().lock();
        try {
            Post post = getPostById(postId);
            checkPermission(post, comment, user);
            post.comments().remove(comment);
            log.info("Delete comment in post {}", post.title());
        } finally {
            lock.writeLock().unlock();
        }
    }

    private Post getPostById(long postId) {
        Post post = posts.get(postId);
        if (post == null) {
            throw new PostNotFoundException(postId);
        }
        return post;
    }

    private void checkPermission(Post post, Comment comment, User user) {
        if (!Objects.equals(post.author(), user) || !Objects.equals(comment.author(), user)) {
            throw new UnauthorizedModificationException();
        }
    }

    private void checkPermission(Post post, User user) {
        if (!Objects.equals(post.author(), user)) {
            throw new UnauthorizedModificationException();
        }
    }
}

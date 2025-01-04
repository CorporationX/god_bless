package derschrank.sprint04.task15.bjstwo_51173;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService implements PostServiceInterface {
    private final Map<Integer, Post> posts;
    private final Lock lock = new ReentrantLock();
    private final AtomicInteger nextId;

    public PostService() {
        posts = new ConcurrentHashMap<>();
        nextId = new AtomicInteger(1);
    }

    @Override
    public void addPost(Post post) {
        lock.lock();
        try {
            posts.put(post.getId(), post);
            System.out.println(post);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void removePost(int postId, Author author) {
        Post post = posts.get(postId);
        if (author.equals(post.getAuthor())) {
            lock.lock();
            try {
                posts.remove(post.getId());
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public void addComment(int postId, Comment comment) {
        Post post = posts.get(postId);
        post.addComment(comment);
        System.out.println(comment);
    }

    @Override
    public void removeComment(int postId, Comment comment, Author author) {
        Post post = posts.get(postId);
        post.removeComment(comment, author);
    }
}

package school.faang.sprint4.bjs251242;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final List<Post> posts;
    private final Lock lock;

    public PostService() {
        this.posts = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

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
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.addComment(comment);
                    return;
                }
            }
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

    public boolean deletePost(int postId, String author) {
        lock.lock();
        try {
            return posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(author));
        } finally {
            lock.unlock();
        }
    }

    public boolean deleteComment(int postId, Comment comment, String author) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId && post.getAuthor().equals(author)) {
                    return post.removeComment(comment);
                }
            }
            return false;
        } finally {
            lock.unlock();
        }
    }
}
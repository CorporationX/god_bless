package comments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private List<Post> posts = new ArrayList<>();
    private Lock lock = new ReentrantLock();

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
            for (var post : posts) {
                if (post.getId() == postId) {
                    post.addComment(comment);
                    return;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(int postId, Comment comment, User user) {
        lock.lock();
        try {
            for (var post : posts) {
                if (post.getId() == postId) {
                    post.removeComment(comment, user);
                    return;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public List<Comment> getComments(int postId) {
        for (var post : posts) {
            if (post.getId() == postId) {
                return post.getComments();
            }
        }
        return new ArrayList<>();
    }

    public void removePost(int postId, User user) {
        lock.lock();
        try {
            posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(user));
        } finally {
            lock.unlock();
        }
    }
}

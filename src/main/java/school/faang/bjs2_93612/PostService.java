package school.faang.bjs2_93612;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

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
            posts.add(postId, comment);
        } finally {
            lock.unlock();
        }
    }
}
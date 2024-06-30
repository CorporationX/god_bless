package faang.school.godbless.multithreading_2.comment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private volatile List<Post> posts = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            posts.stream()
                    .filter(post -> post.id() == postId)
                    .forEach(post -> post.addComment(comment));
        } finally {
            lock.unlock();
        }
    }

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void showPosts() {
        lock.lock();
        try {
            posts.forEach(System.out::println);
        } finally {
            lock.unlock();
        }
    }
}

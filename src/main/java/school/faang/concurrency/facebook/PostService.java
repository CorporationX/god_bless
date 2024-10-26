package school.faang.concurrency.facebook;

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
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.getComments().add(comment);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void showComments(int postId) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    System.out.println(post.getComments());
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(int postId, String author) {
        lock.lock();
        try {
            posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(author)); // Удаление только автором поста        } finally {
        } finally {
            lock.unlock();
        }
    }

    public void allPosts() {
        System.out.println(posts);
    }
}

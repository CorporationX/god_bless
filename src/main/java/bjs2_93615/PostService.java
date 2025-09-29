package bjs2_93615;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            System.out.printf("Пост \"%s\" добавлен пользователем %s%n", post.getId(), post.getAuthor());
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
                    System.out.printf("Комментарий добавлен к посту #%d от %s%n", postId, comment.getAuthor());
                }
            }
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

    public void deleteComment(int postId, LocalDateTime timestamp, String author) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.getComments().removeIf(c ->
                            c.getTimestamp().equals(timestamp) && c.getAuthor().equals(author));
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void showAllPosts() {
        lock.lock();
        try {
            posts.forEach(System.out::println);
        } finally {
            lock.unlock();
        }
    }
}
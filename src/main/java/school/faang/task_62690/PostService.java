package school.faang.task_62690;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    private final Map<Integer, Post> posts = new HashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.put(post.getId(), post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            if (post != null) {
                post.getComments().add(comment);
            } else {
                System.out.println("Пост с ID " + postId + " не найден. Комментарий не добавлен.");
            }
        } finally {
            lock.unlock();
        }
    }

    public void deletePosts(int postId, String author) {
        lock.lock();
        try {
            boolean removed = posts.entrySet().removeIf(post ->
                    post.getKey() == postId && post.getValue().getAuthor().equalsIgnoreCase(author));
            if (removed) {
                System.out.println("Пост с ID " + postId + " удален.");
            } else {
                System.out.println("Пост с ID " + postId + " не найден или автор не совпадает.");
            }
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, String author, LocalDateTime timestamp) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            if (post != null) {
                boolean deleted = post.getComments().removeIf(comment ->
                        comment.getAuthor().equalsIgnoreCase(author)
                                && comment.getTimestamp().equals(timestamp));
                if (deleted) {
                    System.out.println("Комментарий удален.");
                } else {
                    System.out.println("Комментарий не найден.");
                }
            } else {
                System.out.println("Пост с ID " + postId + " не найден.");
            }
        } finally {
            lock.unlock();
        }
    }

    public List<Post> getPosts(String author) {
        lock.lock();
        try {
            return posts.entrySet().stream()
                    .map(Map.Entry::getValue)
                    .filter(post -> post.getAuthor().equalsIgnoreCase(author))
                    .toList();
        } finally {
            lock.unlock();
        }
    }

    public List<Comment> getComments(int postId) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            if (post != null) {
                return post.getComments();
            } else {
                System.out.println("Пост с ID " + postId + " не найден.");
                return Collections.emptyList(); // Возвращаем пустой список, если пост не найден
            }

        } finally {
            lock.unlock();
        }
    }

}

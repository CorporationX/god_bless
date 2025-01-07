package school.faang.sprint_4.task_43585;

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
        Post post = getPostById(postId);
        if (post == null) {
            System.out.println("Пост с id " + postId + " не найден!");
            return;
        }
        lock.lock();
        try {
            post.addComment(comment);
        } finally {
            lock.unlock();
        }
    }

    public void printAllPosts() {
        lock.lock();
        try {
            posts.forEach(System.out::println);
        } finally {
            lock.unlock();
        }
    }

    public void printCommentsByPost(int postId) {
        lock.lock();
        try {
            Post post = getPostById(postId);
            if (post == null) {
                System.out.println("Пост с id " + postId + " не найден!");
                return;
            }
            post.comments().forEach(System.out::println);
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(int postId, String author) {
        lock.lock();
        try {
            posts.removeIf(p -> p.id() == postId && p.author().equals(author));
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int commentId, String author) {
        lock.lock();
        try {
            posts.forEach(post ->
                    post.comments().removeIf(comment ->
                            comment.id() == commentId && comment.author().equals(author)));
        } finally {
            lock.unlock();
        }
    }

    private Post getPostById(int id) {
        return posts.stream()
                .filter(post -> post.id() == id)
                .findFirst()
                .orElse(null);
    }
}

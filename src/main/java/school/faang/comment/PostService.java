package school.faang.comment;

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
            System.out.println("Пост " + post.getTitle() + " добавлен.");
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            posts.get(postId).addComment(comment);
            System.out.println("Кооментарий добавлен.");
        } finally {
            lock.unlock();
        }
    }

    public void displayPost(int postId) {
        System.out.println(posts.get(postId));
    }

    public void displayAllPosts() {
        posts.forEach(System.out::println);
    }

    public void deletePost(int postId, String author) {
        lock.lock();
        try {
           Post removePost = posts.get(postId);
            if (removePost.getAuthor().equals(author)) {
                System.out.println("Пост " + removePost.getTitle() + " удален.");
                posts.remove(removePost);
            } else {
                System.out.println("Пост " + removePost.getTitle() + " не удален.");
            }
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, Comment comment, String author) {
        lock.lock();
        try {
            if (comment.getAuthor().equals(author)) {
                System.out.println("Кооментарий удален.");
                posts.get(postId).deleteComment(comment);
            } else {
                System.out.println("Кооментарий не удален.");
            }
        } finally {
            lock.unlock();
        }
    }
}
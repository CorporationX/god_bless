package faang.school.godbless.BJS2_25310;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
@ToString
public class PostService {
    private volatile List<Post> posts;
    private final Lock lock;

    public PostService() {
        this.posts = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

    public void addComment(Comment comment, int postId) {
        lock.lock();
        try {
            Post post = posts.stream()
                    .filter(p -> p.getId() == postId)
                    .findFirst()
                    .orElseThrow();

            post.addComment(comment);
            System.out.println("Комментарий добавлен к посту с id " + postId + ": " + comment);
        } finally {
            lock.unlock();
        }
    }
    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            System.out.println("Пост добавлен: " + post);
        } finally {
            lock.unlock();
        }
    }
    public void viewPosts() {
        lock.lock();
        try {
            posts.forEach(System.out::println);
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(int postId, String author) {
        lock.lock();
        try {
            posts.removeIf(post -> post.getId() == postId && post.getAuthor().equals(author));
            System.out.println("Пост с id " + postId + " удален автором " + author);
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, String commentAuthor) {
        lock.lock();
        try {
            Post post = posts.stream()
                    .filter(p -> p.getId() == postId)
                    .findFirst()
                    .orElseThrow();

            post.getComments().removeIf(comment -> comment.getAuthor().equals(commentAuthor));
            System.out.println("Комментарий удален из поста с id " + postId + " автором " + commentAuthor);
        } finally {
            lock.unlock();
        }
    }
}

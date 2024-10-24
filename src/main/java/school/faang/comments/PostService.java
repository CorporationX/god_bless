package school.faang.comments;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PostService {
    @Getter
    private volatile List<Post> posts = new ArrayList<>();
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
            posts.stream()
                    .filter(p -> p.getId() == postId)
                    .findFirst()
                    .ifPresent(post -> post.getComments().add(comment));
        } finally {
            lock.unlock();
        }
    }

    public void removePostsByAuthor(String author) {
        lock.lock();
        try {
            posts.removeIf(post -> post.getAuthor().equalsIgnoreCase(author));
        } finally {
            lock.unlock();
        }
    }

    public void removeCommentByAuthor(String author) {
        lock.lock();
        try {
            posts.forEach(p -> p.getComments()
                    .removeIf(comment -> comment.getAuthor()
                            .equalsIgnoreCase(author)));
        } finally {
            lock.unlock();
        }
    }

    public void showAllPosts() {
        posts.forEach(p -> {
            System.out.println("Пост: " + p.getId() + " - "
                    + p.getAuthor() + ", Title: " + p.getTitle()
                    + "\n " + p.getContent());
            p.getComments().forEach(c -> System.out.println("    Комментарий: "
                    + c.getText() + " от " + c.getAuthor()));
        });
    }
}

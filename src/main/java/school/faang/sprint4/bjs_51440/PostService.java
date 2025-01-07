package school.faang.sprint4.bjs_51440;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private final List<Post> posts;
    private final Lock lock = new ReentrantLock();

    public PostService() {
        this.posts = new ArrayList<>();
    }

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
                    .filter(x -> x.getId() == postId)
                    .findFirst()
                    .ifPresent(post -> post.getComments().add(comment));
        } finally {
            lock.unlock();
        }
    }

    public void showPostContent(int postId) {
        posts.stream()
                .filter(x -> x.getId() == postId)
                .findFirst()
                .ifPresent(post -> log.info(post.getContent()));
    }

    public void showPostComments(int postId) {
        posts.stream()
                .filter(x -> x.getId() == postId)
                .findFirst()
                .ifPresent(post -> {
                    for (Comment comment : post.getComments()) {
                        log.info("Пользователь {} оставил комментарий: {}", comment.author(), comment.text());
                    }
                });
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
            posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst()
                    .ifPresent(post ->
                            post.getComments().removeIf(comment ->
                            comment.author().equals(author) && comment.timestamp().equals(timestamp)));
        } finally {
            lock.unlock();
        }
    }
}

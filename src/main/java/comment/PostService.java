package comment;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private final List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            if (!isPostExist(post)) {
                log.info("Пользователь {} добавил пост {} с заголовком '{}' добавлен",
                        post.getAuthor(), post.getId(), post.getTitle());
                posts.add(post);
            } else {
                log.info("Пост {} с заголовком '{}' уже существует",
                        post.getId(), post.getTitle());
            }
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Post post = posts.get(postId);
            if (isPostExist(post)) {
                log.info("Коммент '{}', написанный {}, добавлен к посту {}",
                        comment.text(), comment.author(), postId);
                post.getComments().add(comment);
            } else {
                log.info("Поста {} не существует", postId);
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

    public void deleteComments(int postId, LocalDateTime timestamp, String author) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.getComments().removeIf(comment ->
                            comment.timestamp().equals(timestamp) && comment.author().equals(author));
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean isPostExist(Post post) {
        return posts.contains(post);
    }
}

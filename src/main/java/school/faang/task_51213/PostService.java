package school.faang.task_51213;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private volatile List<Post> posts;
    private final ReentrantLock lock;

    public PostService() {
        this.posts = new ArrayList<>();
        this.lock = new ReentrantLock();
    }

    public void addPost(Post post) {
        if (post == null) {
            log.error("Пост не может быть null!");
            return;
        }

        lock.lock();
        try {
            posts.add(post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        if (comment == null) {
            log.error("Комментарий не может быть null!");
            return;
        }

        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.addComment(comment);
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void viewAllPosts() {
        if (!posts.isEmpty()) {
            posts.forEach(post -> log.info(post.toString()));
        } else {
            log.info("Постов нет!");
        }
    }

    public void viewAllComments(int postId) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    log.info("Комментарии поста {}: {}", postId, post.getComments());
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void deletePost(int postId, String author) {
        lock.lock();
        try {
            if (posts.removeIf(post -> post.getId() == postId && Objects.equals(post.getAuthor(), author))) {
                log.info("Пост {} удален", postId);
            }
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, Comment comment) {
        lock.lock();
        try {
            for (Post post : posts) {
                if (post.getId() == postId) {
                    post.deleteComment(comment);
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
    }
}

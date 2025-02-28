package school.faang.BJS2_62597;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {

    private final List<Post> posts = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.add(post);
            log.info("Добавлен пост: {}", post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            Optional<Post> optionalPost = findPostById(postId);

            if (optionalPost.isPresent()) {
                optionalPost.get().addComment(comment);
                log.info("Комментарий успешно добавлен к посту {}", postId);
            } else {
                log.info("Пост с id {} не найден. Комментарий не добавлен.", postId);
            }
        } finally {
            lock.unlock();
        }
    }

    public Optional<Post> findPostById(int postId) {
        return posts.stream()
                .filter(p -> p.getId() == postId)
                .findFirst();
    }

    public void removePost(int postId, String author) {
        lock.lock();
        try {
            boolean removed = posts.removeIf(p -> p.getId() == postId && p.getAuthor().equals(author));

            if (removed) {
                log.info("Удален пост с id {}", postId);
            } else {
                log.info("Пост с id {} не найден. Удаление не выполнено.", postId);
            }
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(int postId, Comment comment, String author) {
        lock.lock();
        try {
            Post post = findPostById(postId).orElse(null);
            if (post == null) {
                log.info("Пост с id {} не найден", postId);
                return;
            }
            if (post.removeComment(comment, author)) {
                log.info("Комментарий удален из поста {}", postId);
            } else {
                log.info("Комментарий не найден в посте {}", postId);
            }
        } finally {
            lock.unlock();
        }
    }

    public List<Post> getAllPosts() {
        return List.copyOf(posts);
    }
}

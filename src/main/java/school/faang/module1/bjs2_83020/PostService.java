package school.faang.module1.bjs2_83020;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@RequiredArgsConstructor
public class PostService {

    private final List<Post> posts = new CopyOnWriteArrayList<>();
    private final Lock lock = new ReentrantLock();

    public void addPost(Post post) {
        posts.add(post);
        log.info("Пост добавлен: {}", post);
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst()
                    .ifPresent(post -> {
                        post.addComment(comment);
                        log.info("Комментарий добавлен к посту {}: {}", postId, comment);
                    });
        } finally {
            lock.unlock();
        }
    }

    public List<Post> getAll() {
        return new ArrayList<>(posts);
    }

    public boolean deletePost(int postId, String username) {
        lock.lock();
        try {
            boolean removed = posts.removeIf(p -> p.getId() == postId && p.getAuthor().equals(username));
            log.info("Удаление поста {} пользователем {}: {}", postId, username, removed ? "успешно" : "отказано");
            return removed;
        } finally {
            lock.unlock();
        }
    }

    public boolean deleteComment(int postId, Comment comment, String username) {
        lock.lock();
        try {
            return posts.stream()
                    .filter(post -> post.getId() == postId)
                    .findFirst()
                    .filter(post -> comment.getAuthor().equals(username))
                    .map(post -> {
                        boolean removed = post.removeComment(comment);
                        log.info("Удаление комментария из поста {} пользователем {}: {}",
                                postId, username, removed ? "успешно" : "отказано");
                        return removed;
                    })
                    .orElse(false);
        } finally {
            lock.unlock();
        }
    }
}
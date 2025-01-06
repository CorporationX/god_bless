package school.faang.sprint_4.task_51901;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private final List<Post> posts;
    private final ReentrantLock lock = new ReentrantLock();

    public PostService() {
        posts = new CopyOnWriteArrayList<>();
    }

    public synchronized void addPost(Post post) {
        if (post == null) {
            throw new IllegalArgumentException("Публикация не может быть null");
        }

        lock.lock();
        try {
            posts.add(post);
            log.info("Публикация {} добавлена", post.title());
        } finally {
            lock.unlock();
        }
    }

    public void removePost(int postId, String author) {
        if (postId < 0) {
            throw new IllegalArgumentException("ID должен быть больше 0");
        }

        lock.lock();
        try {
            log.info("Попытка удаления публикации ID {} пользователем {}", postId, author);
            boolean removed = posts.removeIf(post -> post.id() == postId && author.equals(post.author()));
            if (removed) {
                log.info("Публикация ID {} удалена", postId);
            } else {
                log.warn("Публикация с ID {} не удалена, так как автор не совпадает или пост не найден", postId);
            }
        } finally {
            lock.unlock();
        }
    }

    public synchronized void addComment(int postId, Comment comment) {
        if (postId < 0) {
            throw new IllegalArgumentException("ID должен быть больше 0");
        }
        if (comment == null) {
            throw new IllegalArgumentException("Комментарий не может быть null");
        }
        Post post = getPostById(postId);

        lock.lock();
        try {
            post.comments().add(comment);
            log.info("К публикации ID {} добавлен комментарий ID {}", postId, comment.id());
        } finally {
            lock.unlock();
        }
    }

    public void removeComment(int commentId, String author) {
        if (commentId < 0) {
            throw new IllegalArgumentException("ID должен быть больше 0");
        }

        lock.lock();
        try {
            boolean removed = false;
            for (Post post : posts) {
                log.info("Поиск комментария ID {} пользователем {} в публикации {}", commentId, author, post.id());
                removed = post.comments().removeIf(comment -> comment.id() == commentId
                        && author.equals(comment.author()));
                if (removed) {
                    log.info("Комментарий с ID {} удален", commentId);
                    break;
                }
            }
            if (!removed) {
                log.warn("Комментарий с ID {} не найден или автор не совпадает", commentId);
            }
        } finally {
            lock.unlock();
        }
    }

    private Post getPostById(int postId) {
        return posts.stream()
                .filter(post -> post.id() == postId)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Публикация с ID " + postId + " не найдена"));
    }
}

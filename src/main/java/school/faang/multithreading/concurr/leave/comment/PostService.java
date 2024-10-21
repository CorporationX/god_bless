package school.faang.multithreading.concurr.leave.comment;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class PostService {
    private ConcurrentHashMap<Integer, Post> posts = new ConcurrentHashMap<>();
    private Lock lock = new ReentrantLock();

    public Optional<Post> getPost(int postId) {
        return Optional.ofNullable(posts.get(postId));
    }

    public void addPost(Post post) {
        lock.lock();
        try {
            posts.put(post.getId(), post);
        } finally {
            lock.unlock();
        }
    }

    public void addComment(int postId, Comment comment) {
        lock.lock();
        try {
            getPost(postId).ifPresentOrElse(post -> post.getComments().add(comment),
                    () -> log.error("Пост с id: {}, не найден", postId));
        } finally {
            lock.unlock();
        }
    }

    public Optional<Post> showPost(int postId) {
        return getPost(postId)
                .map(post -> new Post(
                        post.getId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getAuthor(),
                        new ArrayList<>(post.getComments())
                ));
    }

    public List<Comment> showComments(int postId) {
        return getPost(postId)
                .map(post -> new ArrayList<>(post.getComments()))
                .orElseGet(() -> {
                    log.error("Пост с id: {}, не найден", postId);
                    return new ArrayList<>();
                });
    }

    public void deletePost(int postId, String author) {
        lock.lock();
        try {
            getPost(postId).ifPresentOrElse(post -> {
                if (post.getAuthor().equals(author)) {
                    posts.remove(postId);
                    log.info("Пост с id: {} был удалён автором {}", postId, author);
                } else {
                    log.error("{} не является автором поста c id:{} и не может его удалить", author, postId);
                }
            }, () -> log.error("Пост с id: {}, не найден", postId));
        } finally {
            lock.unlock();
        }
    }

    public void deleteComment(int postId, LocalDateTime timestamp, String author) {
        lock.lock();
        try {
            getPost(postId).ifPresentOrElse(
                    post -> {
                        boolean removed = post.getComments().removeIf(
                                comment -> comment.getTimestamp().equals(timestamp) && comment.getAuthor().equals(author));
                        if (removed) {
                            log.info("Комментарий был удалён автором {}", author);
                        } else {
                            log.error("Комментарий от {} с указанным временем не найден", author);
                        }
                    }, () -> log.error("Пост с id: {}, не найден", postId));
        } finally {
            lock.unlock();
        }
    }
}

package school.faang.task51122;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@AllArgsConstructor
public class PostService {
    private static final int THREAD_RANDOM_SLEEP = 10;

    private final List<Post> posts;
    private final ReadWriteLock postLock = new ReentrantReadWriteLock();
    private final ReadWriteLock commentLock = new ReentrantReadWriteLock();

    private <T> void validate(T... values) {
        Arrays.stream(values).forEach(Objects::requireNonNull);

        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(THREAD_RANDOM_SLEEP));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error message", e);
        }
    }

    private void changePost(Runnable change) {
        postLock.writeLock().lock();

        try {
            change.run();
        } finally {
            postLock.writeLock().unlock();
        }
    }

    private void changeComment(Runnable change) {
        postLock.writeLock().lock();

        try {
            commentLock.writeLock().lock();
            try {
                change.run();
            } finally {
                commentLock.writeLock().unlock();
            }
        } finally {
            postLock.writeLock().unlock();
        }
    }

    public void addPost(Post newPost) {
        validate(newPost);

        changePost(() -> {
            posts.add(newPost);
            log.info("Добавлен новый пост: {}", newPost.id());
        });
    }

    public void addComment(int postId, Comment comment) {
        validate(comment);

        changeComment(() -> {

            Optional<Post> post = posts.stream()
                    .parallel()
                    .filter(oldPost -> oldPost.id() == postId)
                    .findFirst();

            if (post.isPresent()) {
                post.get().comments().add(comment);
            } else {
                log.error("Пост с таким id не существует");
            }
        });
    }

    public void printAllPost() {
        postLock.readLock().lock();

        try {
            posts.forEach(post -> log.info("Post {}", post.id()));
        } finally {
            postLock.readLock().unlock();
        }
    }

    public void printAllComments() {
        postLock.readLock().lock();

        try {
            commentLock.readLock().lock();
            try {
                posts.stream()
                        .parallel()
                        .flatMap(post -> post.comments().stream())
                        .forEach(comment -> log.info("Комментарий текст: {}", comment.text()));
            } finally {
                commentLock.readLock().unlock();
            }
        } finally {
            postLock.readLock().unlock();
        }
    }

    public void removePost(Author author, Post post) {
        validate(author, post);

        changePost(() -> {
            if (posts.removeIf(oldPost -> oldPost.author().equals(author) && oldPost.equals(post))) {
                log.info("Пост: {} удалён пользователем {}", post.id(), author);
            } else {
                log.error("Такого поста не существует.");
            }
        });
    }

    public void removeComment(Author author, Comment comment) {
        validate(author, comment);

        changeComment(() -> posts.stream()
                .parallel()
                .map(Post::comments)
                .forEach(comments -> {
                    if (comments.removeIf(oldComment
                            -> oldComment.author().equals(author) && oldComment.equals(comment))) {
                        log.info("Комментарий: {} удалён пользователем {}", comment.text(), author);
                    } else {
                        log.error("Такого комментария не существует");
                    }
                }));
    }
}

package school.faang.bjs2_93700;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class PostService {
    private static final int NUM_THREADS = 2;
    private static final int TIMEOUT_IN_SECONDS = 10;

    private List<Post> posts = new ArrayList<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
    private final Object postsLock = new Object();

    public void addPost(Post post) {
        executorService.submit(() -> {
            synchronized (postsLock) {
                log.info("Добавляем пост ...");
                posts.add(post);
                log.info("Пост \"{}\" (ID={}) добавлен", post.getTitle(), post.getId());
            }
        });
    }

    public void addComment(int postId, Comment comment) {
        executorService.submit(() -> {
            synchronized (postsLock) {
                log.info("Добавляем комментарий ...");
                try {
                    findNecessaryPost(postId).getComments().add(comment);
                    log.info("Комментарий \"{}\" добавлен", comment.getText());
                } catch (IllegalArgumentException e) {
                    log.error(e.getMessage());
                }
            }
        });

    }

    public void watchPostsAndComments() {
        executorService.submit(() -> {
            synchronized (postsLock) {
                log.info("Выводим посты и их комментарии ...");
                posts.stream()
                        .peek(post ->
                            log.info("Пост \"{}\" (ID={}){}{}{}(C) {}",
                                    post.getTitle(),
                                    post.getId(),
                                    "\n",
                                    post.getContent(),
                                    "\n",
                                    post.getAuthor()))
                        .forEach(post ->
                                post.getComments().forEach(comment ->
                                        log.info("{} -> {} (C) {}",
                                                comment.getTimestamp(),
                                                comment.getText(),
                                                comment.getAuthor())));
            }

        });
    }

    public void deletePost(Post post) {
        executorService.submit(() -> {
            synchronized (postsLock) {
                log.info("Удаляем пост ...");
                if (posts.remove(post)) {
                    log.info("Пост \"{}\" (ID={}) удален", post.getTitle(), post.getId());
                } else {
                    log.info("Такого поста не существует");
                }
            }
        });
    }

    public  void deleteComment(int postId, Comment comment) {
        executorService.submit(() -> {
            synchronized (postsLock) {
                log.info("Удаляем комментарий ...");
                try {
                    if (findNecessaryPost(postId).getComments().remove(comment)) {
                        log.info("Комментарий от {} автора {} удален", comment.getTimestamp(), comment.getAuthor());
                    } else {
                        log.info("Такой комментарий не существует");
                    }
                } catch (IllegalArgumentException e) {
                    log.error(e.getMessage());
                }
            }
        });
    }

    public void shutdownCorrectly() {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)) {
                log.info("Все задачи выполнены");
            } else {
                log.info("Задачи не успели выполниться");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info(e.getMessage());
            executorService.shutdownNow();
        }
    }

    private Post findNecessaryPost(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format("Поста с ID = %d не существует", postId)));
    }
}

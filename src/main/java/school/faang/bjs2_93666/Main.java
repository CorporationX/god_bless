package school.faang.bjs2_93666;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 5;
    private static final int AWAIT_IN_MINUTES = 1;
    private static final int UNIQUE_NUMBER = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        start(executor);
        shutdownExecutor(executor);
    }

    private static void start(ExecutorService executor) {
        PostService postService = new PostService();
        log.info("Запускаем {} потоков", THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            final int threadNumber = i;
            executor.submit(() -> {
                String threadName = "Автор- %s".formatted(threadNumber);
                Thread.currentThread().setName(threadName);
                log.info("{} начал выполнение", threadName);
                try {
                    Post post = createPost(threadNumber, threadName);
                    post.getComments().add(new Comment("Первый комментарий от %s".formatted(threadName),
                            threadName, LocalDate.now()));
                    post.getComments().add(new Comment("Второй комментарий",
                            "Другой автор", LocalDate.now()));
                    log.info("{} вызывает addPost", threadName);
                    postService.addPost(post);
                    Comment newComment = createComment(threadNumber, threadName);
                    log.info("{} вызывает addComment", threadName);
                    postService.addComment(threadNumber + UNIQUE_NUMBER, newComment);
                    log.info("{} вызывает removePost", threadName);
                    postService.removePost(threadNumber + UNIQUE_NUMBER);
                    log.info("{} вызывает removeComment", threadName);
                    postService.removeComment(threadNumber + UNIQUE_NUMBER);
                    log.info("{} успешно завершил выполнение", threadName);
                } catch (Exception e) {
                    log.error("Ошибка в потоке {}: {}", threadName, e.getMessage(), e);
                }
            });
        }
    }

    private static void shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_IN_MINUTES, TimeUnit.MINUTES)) {
                log.info("Потоки не остановились за {} минуту. Останавливаем потоки", AWAIT_IN_MINUTES);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Ошибка в остановке потоков");
            executor.shutdownNow();
        }
    }

    private static Post createPost(int idPost, String threadName) {
        return new Post(
                idPost,
                "Пост от %s".formatted(threadName),
                "Содержание поста от %s".formatted(threadName),
                threadName,
                new CopyOnWriteArrayList<>()
        );
    }

    private static Comment createComment(int threadNumber, String threadName) {
        return new Comment(
                "Новый комментарий от %s в пост %d".formatted(threadName, threadNumber + UNIQUE_NUMBER),
                threadName,
                LocalDate.now()
        );
    }


}

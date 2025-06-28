package school.faang.module1.bjs2_83020;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {

    private static final int TIMEOUT = 20;
    private static final int POOL_SIZE = 5;
    private static final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    public static void main(String[] args) {
        PostService postService = new PostService();

        CompletableFuture<Void> futureForPost1 = CompletableFuture
                .runAsync(
                        () -> postService.addPost(new Post("Первый пост", "Text 1", "Mike")), executor)
                .thenRunAsync(
                        () -> postService.addComment(
                                1, new Comment("Отличный пост!", "Ada", LocalDateTime.now())), executor)
                .thenRunAsync(
                        () -> postService.deletePost(1, "Mike"), executor);


        LocalDateTime timestamp = LocalDateTime.now();

        CompletableFuture<Void> futureForPost2 = CompletableFuture
                .runAsync(
                        () -> postService.addPost(new Post("Второй пост", "Text 2", "Jesse")), executor)
                .thenRunAsync(
                        () -> postService.addComment(
                                2, new Comment("Супер!", "Samantha", LocalDateTime.now())), executor)
                .thenRunAsync(
                        () -> postService.addComment(
                                2, new Comment("Согласен!", "Lucas", timestamp)), executor)
                .thenRunAsync(
                        () -> postService.deleteComment(
                        2, new Comment("Согласен!", "Lucas", timestamp), "Lucas"), executor);

        CompletableFuture.allOf(futureForPost1, futureForPost2).join();

        log.info("Все посты: {}", postService.getAll());

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, java.util.concurrent.TimeUnit.SECONDS)) {
                log.warn("Не все задачи завершились вовремя. Принудительное завершение");
                executor.shutdownNow();
            } else {
                log.info("Пул потоков завершил работу корректно");
            }
        } catch (InterruptedException e) {
            log.error("Главный поток прерван во время ожидания завершения пула", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
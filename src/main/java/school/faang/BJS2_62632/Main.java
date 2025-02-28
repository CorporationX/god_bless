package school.faang.BJS2_62632;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final Random RANDOM = new Random();
    private static final PostService POST_SERVICE = new PostService();
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10);
    private static final long TERMINATION_TIMEOUT = 60;
    private static final AtomicInteger ID = new AtomicInteger();
    private static final String[] USERS = {"Alice", "Bob", "Charlie", "David", "Eve"};

    public static void main(String[] args) {

        for (String user : USERS) {
            EXECUTOR_SERVICE.submit(() -> {
                try {
                    Post post = new Post(ID.getAndIncrement(), "Title by " + user, "Content by " + user, user);
                    POST_SERVICE.addPost(post);
                    log.info("{} добавил пост: {}", user, post.getTitle());
                } catch (RuntimeException e) {
                    log.error("Ошибка при добавлении поста: {}", e.getMessage(), e);
                }
            });
        }

        // Добавляем задачи для создания комментариев
        for (String user : USERS) {
            EXECUTOR_SERVICE.submit(() -> {
                try {
                    int postId = getRandomIdPost();
                    Comment comment = new Comment("Nice post!", user);
                    POST_SERVICE.addComment(postId, comment);
                    log.info("{} добавил комментарий к посту {}", user, postId);
                } catch (RuntimeException e) {
                    log.error("Ошибка при добавлении комментария: {}", e.getMessage(), e);
                }
            });
        }

        shutdownAndAwaitTermination(EXECUTOR_SERVICE);

        POST_SERVICE.viewPosts();
    }

    private static void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                log.warn("Пул потоков был принудительно завершен из-за превышения времени ожидания.");
            } else {
                log.info("Все задачи успешно завершены.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
            log.error("Завершение пула потоков было прервано: {}", e.getMessage(), e);
        }
    }

    private static int getRandomIdPost() {
        List<Integer> ids;
        do {
            ids = POST_SERVICE.getPosts().keySet().stream().toList();
        } while (ids.isEmpty());
        return ids.get(RANDOM.nextInt(0, ids.size()));
    }
}
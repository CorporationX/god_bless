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
    private static final Random random = new Random();
    private static final PostService postService = new PostService();
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        String[] users = {"Alice", "Bob", "Charlie", "David", "Eve"};
        AtomicInteger id = new AtomicInteger();

        for (String user : users) {
            executorService.submit(() -> {
                try {
                    Post post = new Post(id.getAndIncrement(), "Title by " + user, "Content by " + user, user);
                    postService.addPost(post);
                    log.info("{} добавил пост: {}", user, post.getTitle());
                } catch (RuntimeException e) {
                    log.error("Ошибка при добавлении поста: {}", e.getMessage(), e);
                }
            });
        }

        // Добавляем задачи для создания комментариев
        for (String user : users) {
            executorService.submit(() -> {
                try {
                    int postId = getRandomIdPost();
                    Comment comment = new Comment("Nice post!", user);
                    postService.addComment(postId, comment);
                    log.info("{} добавил комментарий к посту {}", user, postId);
                } catch (RuntimeException e) {
                    log.error("Ошибка при добавлении комментария: {}", e.getMessage(), e);
                }
            });
        }

        shutdownAndAwaitTermination(executorService);

        postService.viewPosts();
    }

    private static void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
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
            ids = postService.getPosts().keySet().stream().toList();
        } while (ids.isEmpty());
        return ids.get(random.nextInt(0, ids.size()));
    }
}
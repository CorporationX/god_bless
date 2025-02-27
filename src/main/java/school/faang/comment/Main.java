package school.faang.comment;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final long PROCEED_TIME_IN_MS = 2000;
    private static final int TERMINATION_TIMEOUT = 5;

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.execute(() -> postService.addPost(new Post("Заголовок 1", "Текст 1", "Автор1")));
        executor.execute(() -> postService.addPost(new Post("Заголовок 2", "Текст 2", "Автор2")));
        executor.execute(() -> postService.addPost(new Post("Заголовок 3", "Текст 3", "Автор3")));

        sleep();

        executor.execute(() -> postService.addComment(1,
                new Comment("Комментарий 1", "Пользователь1", LocalDateTime.now())));
        executor.execute(() -> postService.addComment(1,
                new Comment("Комментарий 2", "Пользователь2", LocalDateTime.now())));
        executor.execute(() -> postService.addComment(2,
                new Comment("Комментарий 3", "Пользователь3", LocalDateTime.now())));

        sleep();

        executor.execute(() -> postService.removePost(1, "Автор1"));
        executor.execute(() -> postService.removePost(2, "НеАвтор"));

        sleep();

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(PROCEED_TIME_IN_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

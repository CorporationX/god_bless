package faang.school.godbless.multithreading_2.comment;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 3;
    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        // добавление постов
        executor.execute(() -> postService.addPost(
                new Post(1,"Первый пост", "Написан первый пост", "Иванов Иван" ))
        );
        executor.execute(() -> postService.addPost(
                new Post(2,"Второй пост", "Написан второй пост", "Иванов Иван" ))
        );

        // добавление комментариев к постам
        executor.execute(() -> postService.addComment(
                1,
                new Comment(
                        "Первый комментарий",
                        LocalDateTime.of(2024, Month.JUNE, 29, 6, 30),
                        "Петров Пётр"
                )
        ));
        executor.execute(() -> postService.addComment(
                1,
                new Comment(
                        "Второй комментарий",
                        LocalDateTime.of(2024, Month.JUNE, 29, 6, 33),
                        "Петров Пётр"
                )
        ));
        executor.execute(() -> postService.addComment(
                1,
                new Comment(
                        "Третий комментарий",
                        LocalDateTime.of(2024, Month.JUNE, 29, 6, 35),
                        "Петров Пётр"
                )
        ));
        executor.execute(() -> postService.addComment(
                2,
                new Comment(
                        "Первый комментарий",
                        LocalDateTime.of(2024, Month.JUNE, 29, 16, 35),
                        "Васильев Василий"
                )
        ));
        executor.execute(() -> postService.addComment(
                2,
                new Comment(
                        "Второй комментарий",
                        LocalDateTime.of(2024, Month.JUNE, 29, 16, 38),
                        "Васильев Василий"
                )
        ));

        executor.shutdown();
        boolean isTerminated = executor.awaitTermination(1, TimeUnit.MINUTES);
        postService.showPosts();
        System.out.println("Потоки завершены " + isTerminated);

    }
}

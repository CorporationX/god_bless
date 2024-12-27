package school.faang.sprint_4.task_51901;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class Main {
    static PostService postService = new PostService();

    public static void main(String[] args) {

        List<CompletableFuture<Void>> futures = getFutures();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRunAsync(() -> {
                    try {
                        postService.removeComment(1, "Автор 1");
                        postService.removePost(2, "Автор 2");
                        postService.removePost(2, "Автор 1");
                    } catch (Exception e) {
                        log.error("Произошла ошибка {}:", e.getMessage());
                    }
                }).whenComplete((result, throwable) -> {
                    if (throwable == null) {
                        log.info("Все задачи завершены");
                    } else {
                        log.error("Возникла ошибка при выполнении задач: {}", throwable.getMessage());
                    }
                }).join();

    }

    private static List<CompletableFuture<Void>> getFutures() {

        CompletableFuture<Void> user1Task = CompletableFuture.runAsync(() -> {
            try {
                Post post1 = new Post(1, "Заголовок поста 1", "Текст поста 1", "Автор 1", new CopyOnWriteArrayList<>());
                postService.addPost(post1);

                Comment comment1 = new Comment(1, "Комментарий 1 от автора 1", "Автор 1", LocalDateTime.now());
                postService.addComment(1, comment1);
            } catch (Exception e) {
                log.error("Произошла ошибка {}:", e.getMessage());
            }
        });

        CompletableFuture<Void> user2Task = CompletableFuture.runAsync(() -> {
            try {
                Post post2 = new Post(2, "Заголовок поста 2", "Текст поста 2", "Автор 2", new CopyOnWriteArrayList<>());
                postService.addPost(post2);

                Comment comment2 = new Comment(2, "Комментарий 2 от автора 2", "Автор 2", LocalDateTime.now());
                postService.addComment(2, comment2);
            } catch (Exception e) {
                log.error("Произошла ошибка {}:", e.getMessage());
            }
        });

        CompletableFuture<Void> user3Task = CompletableFuture.runAsync(() -> {
            try {
                Post post3 = new Post(3, "Заголовок поста 3", "Текст поста 3", "Автор 3", new CopyOnWriteArrayList<>());
                postService.addPost(post3);

                Comment comment3 = new Comment(3, "Комментарий 3 от автора 3", "Автор 3", LocalDateTime.now());
                postService.addComment(3, comment3);
            } catch (Exception e) {
                log.error("Произошла ошибка {}:", e.getMessage());
            }
        });

        return List.of(user1Task, user2Task, user3Task);
    }
}

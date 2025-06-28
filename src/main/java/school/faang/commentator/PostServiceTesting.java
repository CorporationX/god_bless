package school.faang.commentator;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PostServiceTesting {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        PostService postService = new PostService();

        Post post1 = new Post(1, "Dog", "I have a cute dog", "Egor");
        Post post2 = new Post(2, "Cat", "I have two cute cats", "Aleksandr");
        Comment comment1 = new Comment("great", "Andrey",
                LocalDateTime.of(2024, Month.APRIL, 27, 15, 30));
        Comment comment2 = new Comment("beautiful", "Katy",
                LocalDateTime.of(2024, Month.JUNE, 14, 12, 10));


        executor.submit(() -> postService.addPost(post1));
        executor.submit(() -> postService.addPost(post2));
        executor.submit(() -> postService.addComment(post1.getId(), comment1));
        executor.submit(() -> postService.addComment(post2.getId(), comment2));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за 5 минут, принудительно останавливаем...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        postService.printPosts();
        postService.printComment(post1);
    }
}

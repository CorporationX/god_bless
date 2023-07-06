package faang.school.godbless.sprint5.multithreading_conc.task1_comment;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Post post1 = new Post(1, "Tesla top car", "Tesla is the best car", "Ilon Mask");
        Comment comment1 = new Comment("Как тебе такое Илон Макс", LocalDateTime.now(), "Вася");
        Comment comment2 = new Comment("Новый электрический Москвич лучше будет", LocalDateTime.now(), "Дан");
        Comment comment3 = new Comment("Где купить картошку?", LocalDateTime.now(), "Ыкар");
        Comment comment4 = new Comment("Как тебе такое Илон Макс", LocalDateTime.now(), "Ролик");
        PostService postService = new PostService();

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(() -> postService.addPost(post1));
        executor.execute(() -> postService.addComment(0, comment1));
        executor.execute(() -> postService.addComment(0, comment2));
        executor.execute(() -> postService.addComment(0, comment3));
        executor.execute(() -> postService.addComment(0, comment4));

        executor.execute(() -> postService.deletePost(post1, "Вася"));
        executor.execute(() -> postService.deleteComment(0, comment1, "Вася"));

        executor.shutdown();
    }
}

package school.faang.sprint_4.task_43585;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final int TIMEOUT = 5;
    private static final int COMMENTS_NUM = 5;
    private static final int POOL_SIZE = 10;

    private static final AtomicInteger NUM_GENERATOR = new AtomicInteger(0);

    public static void main(String[] args) {
        PostService postService = new PostService();

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

        for (int i = 0; i < POOL_SIZE; i++) {
            executor.execute(() -> {
                int num = NUM_GENERATOR.getAndIncrement();
                postService.addPost(new Post("Title " + num, "Content " + num,
                        "Author " + num, new ArrayList<>()));
                postService.addComment(num, new Comment("Text " + num,
                        "Author " + num, LocalDateTime.now()));

            });
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        postService.printAllPosts();
        postService.printCommentsByPost(1);
    }
}
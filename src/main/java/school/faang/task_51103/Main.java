package school.faang.task_51103;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 10;
    private static final int AWAIT_TERMINATION_TIME = 60;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        LocalDateTime currentDateTime = LocalDateTime.now();
        PostService postService = new PostService();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            futures.add(postService.addPost(
                    new Post(i, "Title" + i, "Content" + i, "Author" + i, new ArrayList<>()),
                    executor));
        }

        CompletableFuture<?>[] futureArray = futures.toArray(new CompletableFuture[0]);
        CompletableFuture.allOf(futureArray).thenRun(() -> {
            CompletableFuture<Void> future1 =
                    postService.addComment(1,
                            new Comment("Nice post!", "User1", currentDateTime), executor);
            CompletableFuture<Void> future2 =
                    postService.addComment(1,
                            new Comment("Thanks for sharing", "User2", currentDateTime), executor);
            CompletableFuture.allOf(future1, future2).thenRun(postService::showPostsWithComments);
        }).join();


        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

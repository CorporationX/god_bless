package school.faang.sprint_4.task_51093;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();
    private static final int NUMBER_OF_USERS = 200;
    private static final int AWAIT_TIME = 1;

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 1; i <= NUMBER_OF_USERS; i++) {
            int finalI = i;
            futures.add(CompletableFuture.runAsync(() -> {
                Post post = new Post(finalI,
                        "Post " + finalI,
                        "Content " + finalI,
                        "Author " + finalI);
                postService.addPost(post);
                Post postById = postService.getPostById(finalI - 1).orElse(post);
                postById.addComment(new Comment("Comment from " + finalI,
                        "Author " + finalI,
                        LocalDateTime.now()));
            }, executorService));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println(postService.getPosts());

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_TIME, TimeUnit.MINUTES)) {
                log.info("Await timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Main thread interrupted. Shutting down...");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

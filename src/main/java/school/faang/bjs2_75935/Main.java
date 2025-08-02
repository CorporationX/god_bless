package school.faang.bjs2_75935;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static List<Author> authors = IntStream.range(0, 10)
        .mapToObj(index -> new Author("Author#%d".formatted(index + 1)))
        .toList();

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture.allOf(
                IntStream.range(0, 40)
                    .mapToObj(value ->
                        CompletableFuture.runAsync(() ->
                            postService.addPost(
                                "title-%d".formatted(getIndex(20)),
                                "content-%d".formatted(getIndex(20)),
                                authors.get(getIndex(9))
                            ), executor
                        )
                    )
                    .toArray(CompletableFuture[]::new)
            )
            .join();

        gracefullyShutdown(executor);
        log.info("total authors is: {}", authors.size());
        log.info("total post is: {}", postService.getPostCount());
        authors.forEach(
            author -> {
                log.info("author [{}] post list: {}", author, postService.findAllPostsByAuthor(author));
            }
        );
        postService.findAllPosts().forEach(post -> log.info("all post: {}", post));
    }

    private static void gracefullyShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (executor.awaitTermination(2, TimeUnit.MINUTES)) {
                log.info("All tasks are completed.");
            } else {
                List<Runnable> notExecuted = executor.shutdownNow();
                log.info("{} tasks failed to start.", notExecuted.size());
            }
        } catch (InterruptedException e) {
            log.error("error in gracefullyShutdown method: {}", e.getMessage(), e);
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }

    private static int getIndex(Integer maxValue) {
        double dbl = Math.random() / Math.nextDown(1.0);
        return (int) Math.round(maxValue * dbl);
    }
}

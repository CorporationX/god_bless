package faang.school.godbless.BJS2_25438;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int THREAD_POOL_COUNT = 10;
    private static final int POSTS_COUNT = 10;
    private static final int COMMENTS_COUNT = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_COUNT);
        PostService postService = new PostService(new HashMap<>());
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (long i = 0; i < POSTS_COUNT; i++) {
            long finalI = i;
            futures.add(CompletableFuture.runAsync(() -> {
                postService.addPost(new Post(finalI, "Title" + finalI, "Content" + finalI, new Author(finalI, "Author" + finalI), new HashMap<>()));
                for (long j = 0; j < COMMENTS_COUNT; j++) {
                    postService.addComment(finalI, new Comment(j, "Comment" + j, LocalDateTime.now(), new Author(j, "Author" + j)));
                }
            }));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(postService::showPosts)
                .join();

        for (long i = 0; i < POSTS_COUNT; i += 2) {
            long finalI1 = i;
            executorService.execute(() -> {
                postService.removeComment(finalI1, finalI1, new Author(finalI1, "Author" + finalI1));
                postService.removePost(finalI1, new Author(finalI1, "Author" + finalI1));
            });
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                postService.showPosts();
            } else {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            executorService.shutdownNow();
            throw new RuntimeException(e);
        }

    }
}

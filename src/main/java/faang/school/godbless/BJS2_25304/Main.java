package faang.school.godbless.BJS2_25304;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int COMMENTS_COUNT = 50;
    private static final int POSTS_COUNT = 3;
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        PostService postService = new PostService();

        for (int i = 0; i < POSTS_COUNT; i++) {
            int finalI = i;
            executorService.execute(() -> postService
                    .addPost(new Post(finalI, "Header of " + Thread.currentThread().getName(), "Hello there",
                            Thread.currentThread().getName())));
        }

        for (int i = 0; i < COMMENTS_COUNT; i++) {
            executorService.execute(() -> {
                postService.addComment(new Comment("content of " + Thread.currentThread().getName(), LocalDate.now(),
                        Thread.currentThread().getName()), ThreadLocalRandom.current().nextInt(POSTS_COUNT));
            });
        }

        executorService.execute(() -> postService.deletePost(ThreadLocalRandom.current().nextInt(0, 3)));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread died: {}", Thread.currentThread().getName());
        }

        System.out.println(postService.getPosts().size());
        postService.getPosts().forEach(post -> System.out.println(post.comments().size()));
    }
}

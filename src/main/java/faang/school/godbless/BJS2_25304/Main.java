package faang.school.godbless.BJS2_25304;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int COMMENTS_COUNT = 50;
    private static final int POSTS_COUNT = 3;
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
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

        executorService.shutdown();
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("Hi");
        postService.getPosts().forEach(post -> System.out.println(post.comments().size()));
    }
}

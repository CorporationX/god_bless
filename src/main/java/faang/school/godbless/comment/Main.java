package faang.school.godbless.comment;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private static PostService postService = new PostService();

    private static final int POSTS_COUNT = 10;
    private static final int COMMENTS_COUNT = 5;
    private static final int POSTS_TO_DELETE = 3;
    private static final int COMMENTS_TO_DELETE = 20;

    public static void main(String[] args) throws InterruptedException {
        addFewPosts();
        addFewComment();
        deleteFewComment();
        deleteFewPost();

        executorService.shutdown();

        while (!executorService.awaitTermination(20, TimeUnit.SECONDS)) {
        }
    }

    private static void addFewComment() {
        for (int i = 0; i < COMMENTS_COUNT; i++) {
            int finalI = i;
            executorService.execute(() -> {
                int random = ThreadLocalRandom.current().nextInt(1, 10);
                postService.addComment(
                        new Comment(Thread.currentThread().getName(), "comment_" + finalI, LocalDateTime.now()),
                        random
                );
            });
        }
    }

    private static void addFewPosts() {
        for (int i = 0; i < POSTS_COUNT; i++) {
            int finalI = i;
            executorService.execute(() -> postService.addPost(
                    new Post(Thread.currentThread().getName(), "headline_" + finalI, "text_" + finalI)
            ));
        }
    }

    private static void deleteFewPost() {
        for (int i = 0; i < POSTS_TO_DELETE; i++) {
            int random = ThreadLocalRandom.current().nextInt(1, POSTS_COUNT);
            executorService.execute(
                    () -> postService.deletePost(random)
            );
        }
    }

    public static void deleteFewComment() {
        for (int i = 0; i < COMMENTS_TO_DELETE; i++) {
            int random = ThreadLocalRandom.current().nextInt(1, POSTS_COUNT);
            executorService.execute(
                    () -> postService.deleteComment(random, Thread.currentThread().getName())
            );
        }
    }
}

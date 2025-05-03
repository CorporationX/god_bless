package faang.BJS2_75968;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final int THREAD_COUNT = 10;
    private static final AtomicInteger counter = new AtomicInteger();
    private static final int CONTENT_COUNT = 20;
    private static final int TITLE_COUNT = 20;
    private static final int AUTHOR_COUNT = 20;
    private static final int TEXT_COUNT = 20;
    private static final int AWAIT_TERMINATION_TIME = 20;


    public static void main(String[] args) {
        final PostService postService = new PostService();
        final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            executorService.execute(() -> {
                final Random random = ThreadLocalRandom.current();
                final Post post = getPost(random);
                final Comment comment = getComment(random);

                postService.addPost(post);
                postService.addComment(post.getId(), comment);
                postService.deleteComment(post.getId(), comment, comment.author());
                postService.deletePost(post.getId(), post.getAuthor());
            });
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private static Comment getComment(Random random) {
        return new Comment(
                "Text: " + random.nextInt(TEXT_COUNT),
                "Author: " + random.nextInt(AUTHOR_COUNT),
                LocalDateTime.now()
        );
    }

    private static Post getPost(Random random) {
        return new Post(
                counter.getAndIncrement(),
                "Title: " + random.nextInt(TITLE_COUNT),
                "Content: " + random.nextInt(CONTENT_COUNT),
                "Author: " + random.nextInt(AUTHOR_COUNT));
    }
}

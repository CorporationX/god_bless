package school.faang.leavingComments;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final Random random = new Random();
    private static final int MAX_HOURS = 24;
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        PostService postService = new PostService();
        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.execute(() -> {
                postService.addPost(new Post(
                        10, "Title 10", "Content 10", "Author 10", Comment.generateComments())
                );
                postService.addComment(10, new Comment(
                        "Comment 10", "Author 10", LocalDateTime.now().minusHours(random.nextInt(MAX_HOURS)))
                );
                postService.viewPost(10);
                postService.deletePost(10, "Author 10");
                postService.deleteComment(10, null, "Author 10");
            });
        }
        executorService.shutdown();
    }
}

package school.faang.task_51182;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_COMMENTS = 10;
    private static final int SHUTDOWN_TIMEOUT_SECONDS = 10;

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executor = ExecutorServiceFactory.getExecutorService();

        User user1 = new User("Alice");
        User user2 = new User("Bob");

        Post post1 = new Post("Post 1", "Content of Post 1", user1);
        Post post2 = new Post("Post 2", "Content of Post 2", user2);

        postService.addPost(post1);
        postService.addPost(post2);

        Runnable addCommentsTask = () -> {
            for (int i = 0; i < NUM_COMMENTS; i++) {
                Comment comment = new Comment("Comment " + i, user1, LocalDateTime.now());
                postService.addComment(post1.getId(), comment);
                log.info("Added comment: {}", comment);
            }
        };

        Runnable deleteCommentsTask = () -> {
            for (UUID commentId : post1.getComments().keySet()) {
                postService.deleteComment(post1.getId(), commentId);
                log.info("Deleted comment with ID: {}", commentId);
            }
        };

        executor.submit(addCommentsTask);
        executor.submit(deleteCommentsTask);

        executor.shutdown();
        try {
            if (executor.awaitTermination(SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                log.info("Remaining comments in post1: {}", post1.getComments().size());
                log.info("All tasks successfully completed");
            } else {
                log.warn("Tasks are not completed");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error during shutdown: {}", e.getMessage());
            executor.shutdownNow();
        }
    }
}
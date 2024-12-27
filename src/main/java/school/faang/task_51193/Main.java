package school.faang.task_51193;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        User user1 = new User("Alice");
        User user2 = new User("Bob");

        Post post1 = new Post("Post 1", "Content of Post 1", user1);
        Post post2 = new Post("Post 2", "Content of Post 2", user2);

        postService.addPost(post1);
        postService.addPost(post2);

        Runnable addCommentsTask = () -> {
            for (int i = 0; i < 10; i++) {
                Comment comment = new Comment("Comment " + i, user1, LocalDateTime.now());
                postService.addComment(post1.getId(), comment);
            }
        };

        Runnable deleteCommentsTask = () -> {
            post1.getComments().keySet().forEach(commentId -> {
                postService.deleteComment(post1.getId(), commentId);
            });
        };

        for (int i = 0; i < 5; i++) {
            executor.execute(addCommentsTask);
            executor.execute(deleteCommentsTask);
        }

        executor.shutdown();
        try {
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.info("Remaining comments in post1: {}", post1.getComments().size());
                log.info("All tasks successfully completed");
            } else {
                log.info("Tasks are not completed");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }
}

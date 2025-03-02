package school.faang.sprint.fourth.facebookcomments;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int AWAIT_TIME = 20;
    private static final int THREAD_POOL_SIZE = 10;
    private static final int POSTS_COUNT = 10;
    private static final int COMMENTS_COUNT = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        PostService postService = new PostService();
        for (int i = 0; i < POSTS_COUNT; i++) {
            int finalI = i;
            executorService.submit(() -> {
                Post post = new Post(finalI, "Some post " + finalI, "Post body " + finalI, "Post author " + finalI);
                postService.addPost(post);

                for (int j = 1; j <= COMMENTS_COUNT; j++) {
                    Comment comment =
                            new Comment("Some comment", "Comment author" + j, new Timestamp(new Date().getTime()));
                    postService.addComment(1, comment);
                }
                postService.removePost(1);
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TIME, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while awaiting termination: {}", e.getMessage());
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        Optional<Post> optionalPost = postService.findPost(1);
        if (optionalPost.isEmpty()) {
            log.info("No post found with id {}", 1);
        }
        log.info("Comments for post: {}", postService.getComments(1));
    }
}

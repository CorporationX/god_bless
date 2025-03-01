package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int TIMEOUT_SECONDS = 30;
    private static final int NUMBER_OF_POSTS = 5;
    private static final int NUMBER_OF_COMMENTS = 5;
    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static void main(String[] args) {
        PostService postService = new PostService();
        addPosts(postService);
        addComments(postService);
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.warn("Not all tasks have been completed on time.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            log.error("awaitTermination was interrupted");
        }
    }

    private static void addComments(PostService postService) {
        for (int i = 1; i <= NUMBER_OF_COMMENTS; i++) {
            Comment comment = new Comment("This is a comment", "Commenter" + i, LocalDateTime.now());
            int finalI = i;
            executor.submit(() -> postService.addComment(finalI, comment));
        }
    }

    private static void addPosts(PostService postService) {
        for (int i = 1; i <= NUMBER_OF_POSTS; i++) {
            Post post = new Post(i, "Post Title " + i, "Content of post " + i,
                    "Author" + i, new ArrayList<>());
            executor.submit(() -> postService.addPost(post));
        }
    }
}
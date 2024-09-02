package faang.school.godbless.LeaveComment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 3;
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        try {
            generatePosts(executor, postService);
            generateComments(executor, postService);
            removeAnyComment(executor, postService);
            removeAnyPost(executor, postService);
        } finally {
            shutdownExecutor(executor);
        }
    }

    private static void generatePosts(ExecutorService executor, PostService postService) {
        List<Post> posts = Arrays.asList(
                new Post("First Post", "This is the first post", "Author 1"),
                new Post("Second Post", "This is the second post", "Author 2"),
                new Post("Third Post", "This is the third post", "Author 3")
        );

        posts.forEach(post -> executor.submit(() -> postService.addPost(post)));
    }

    private static void removeAnyPost(ExecutorService executor, PostService postService) {
        executor.submit(() ->
                postService.getPosts().stream()
                    .findAny()
                    .ifPresent(post -> postService.removePost(post.getId()))
        );
    }

    private static void generateComments(ExecutorService executor, PostService postService) {
        executor.submit(() -> {
            List<Post> posts = postService.getPosts();
            for (int i = 0; i < posts.size(); i++) {
                String postId = posts.get(i).getId();
                for (int j = 0; j <= i; j++) {
                    postService.addComment(
                            new Comment("Comment on post " + (i + 1), "User " + (j + 1)),
                            postId
                    );
                }
            }
        });
    }

    private static void removeAnyComment(ExecutorService executor, PostService postService) {
        executor.submit(() ->
            postService.getPosts().stream()
                    .findAny()
                    .ifPresent(post ->
                        post.getComments().stream()
                                .findAny()
                                .ifPresent(comment -> postService.removeComment(comment.getId(), post.getId()))
                    )
        );
    }

    private static void shutdownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                log.warn("Executor service did not terminate in the allotted time.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            log.error("Executor service was interrupted during shutdown.", e);
        }
    }
}
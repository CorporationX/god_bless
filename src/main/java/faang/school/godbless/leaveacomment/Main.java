package faang.school.godbless.leaveacomment;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(() -> postService.addPost(new Post(1, "Post1", "Content1", "User1")));
        executorService.submit(() -> postService.addPost(new Post(2, "Post2", "Content2", "User2")));
        executorService.submit(() -> postService.addPost(new Post(3, "Post3", "Content3", "User3")));

        executorService.submit(() -> postService.addComment(1, new Comment("Comment 1", "User1")));
        executorService.submit(() -> postService.addComment(1, new Comment("Comment 2", "User2")));
        executorService.submit(() -> postService.addComment(1, new Comment("Comment 3", "User3")));

        executorService.submit(() -> {
            Comment commentToDelete = new Comment("Comment 2", "User2");
            postService.removeComment(1, commentToDelete, "User2");
        });

        executorService.submit(() -> postService.removePost(2, "User2"));

        shutdown(executorService);

        postService.getPosts().values().forEach(System.out::println);
    }

    private static void shutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(20, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(20, TimeUnit.SECONDS)) {
                    log.error("Pool did not terminate");
                }
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
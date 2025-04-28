package school.faang.facebook;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture<Void> addPosts = CompletableFuture.allOf(
                CompletableFuture.runAsync(() ->
                    postService.addPost(new Post(1, "Post 1", "Content 1", "user1")), executor),
                CompletableFuture.runAsync(() ->
                    postService.addPost(new Post(2, "Post 2", "Content 2", "user2")), executor)
        );

        Comment comment1 = new Comment("Comment 1-1", "user1");
        Comment comment2 = new Comment("Comment 1-2", "user2");
        Comment comment3 = new Comment("Comment 2-1", "user1");
        Comment comment4 = new Comment("Comment 2-2", "user1");
        Comment comment5 = new Comment("Comment 2-3", "user2");


        CompletableFuture<Void> addComments = addPosts.thenCompose(v ->
                CompletableFuture.allOf(
                        CompletableFuture.runAsync(() -> postService.addComment(1, comment1), executor),
                        CompletableFuture.runAsync(() -> postService.addComment(1, comment2), executor),
                        CompletableFuture.runAsync(() -> postService.addComment(2, comment3), executor),
                        CompletableFuture.runAsync(() -> postService.addComment(2, comment4), executor),
                        CompletableFuture.runAsync(() -> postService.addComment(2, comment5), executor)
                )
        );

        CompletableFuture<Void> removeOperations = addComments.thenCompose(v ->
                CompletableFuture.allOf(
                        CompletableFuture.runAsync(() -> {
                            boolean removed = postService.removePost(1, "user1");
                            log.info("Удаление Post 1 user1 (ожидается true): {}", removed);
                        }, executor),
                        CompletableFuture.runAsync(() -> {
                            boolean removed = postService.removePost(2, "user1");
                            log.info("Удаление Post 2 user1 (ожидается false): {}", removed);
                        }, executor),
                        CompletableFuture.runAsync(() -> {
                            boolean removed = postService.removeComment(2, comment4, "user1");
                            log.info("Удаление Comment #4 user1 (ожидается true): {}", removed);
                        }, executor),
                        CompletableFuture.runAsync(() -> {
                            boolean removed = postService.removeComment(2, comment3, "user2");
                            log.info("Удаление Comment #3 user2 (ожидается false): {}", removed);
                        }, executor)
                )
        );

        CompletableFuture<Void> finalState = removeOperations.thenRunAsync(() -> {
            log.info("Итоговое состояние:");
            List<Post> allPosts = postService.getAllPosts();
            if (allPosts.isEmpty()) {
                log.info("Нет постов");
            } else {
                allPosts.forEach(post -> {
                    log.info("{} (id:{}) от {}",
                            post.getTitle(),
                            post.getId(),
                            post.getAuthor());
                    post.getComments().forEach(comment ->
                            log.info("  {}: {}",
                                    comment.getAuthor(),
                                    comment.getText()));
                });
            }
        }, executor);

        finalState.exceptionally(ex -> {
            log.error("Ошибка выполнения: ", ex);
            return null;
        }).join();
        executor.shutdown();
    }
}
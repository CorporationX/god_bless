package faang.school.godbless.sprint.four.comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String... args) {
        User user1 = new User(1, "vasia");
        User user2 = new User(2, "kolia");
        User user3 = new User(3, "dan");

        PostService postService = new PostService();

        List<Integer> commentIdToRemove = new ArrayList<>(List.of(1, 2, 4, 6, 8));
        user1.setIdsForDelete(commentIdToRemove);

        List<Post> postQueue = new ArrayList<>(List.of(
                new Post(1, user1.getId(), "Title 1", "Author 1"),
                new Post(2, user2.getId(), "Title 2", "Author 2"),
                new Post(3, user3.getId(), "Title 3", "Author 3"),
                new Post(4, user2.getId(), "Title 4", "Author 4")
        ));

        List<Comment> commentQueue = new ArrayList<>(List.of(
                new Comment(1, user1.getId(), "Comment 1", LocalDateTime.now()),
                new Comment(2, user2.getId(), "Comment 2", LocalDateTime.now()),
                new Comment(3, user3.getId(), "Comment 3", LocalDateTime.now()),
                new Comment(4, user2.getId(), "Comment 4", LocalDateTime.now()),
                new Comment(5, user2.getId(), "Comment 5", LocalDateTime.now()),
                new Comment(6, user2.getId(), "Comment 6", LocalDateTime.now()),
                new Comment(7, user3.getId(), "Comment 7", LocalDateTime.now()),
                new Comment(8, user1.getId(), "Comment 8", LocalDateTime.now())
        ));


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture<Void> allPosts = CompletableFuture.allOf(
                postQueue.stream()
                        .map(post -> CompletableFuture.runAsync(() -> postService.addPost(post), executorService))
                        .toArray(CompletableFuture[]::new)
        ).thenAccept(v ->
                CompletableFuture.allOf(
                        commentQueue.stream()
                                .map(comment -> CompletableFuture.runAsync(
                                        () -> postService.addComment(postService.getRandomPost(), comment), executorService)
                                )
                                .toArray(CompletableFuture[]::new)
                )
        ).thenAccept(v ->
                CompletableFuture.allOf(
                        commentIdToRemove.stream()
                                .map(id -> CompletableFuture.runAsync(() -> {
                                    postService.removeComment(id, user1.getId());
                                }, executorService).exceptionally(ex -> {
                                    System.err.println( ex.getMessage());
                                    return null;
                                }))
                                .toArray(CompletableFuture[]::new)
                )
        );

        allPosts.join();

        executorService.shutdown();


        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finish");


    }
}

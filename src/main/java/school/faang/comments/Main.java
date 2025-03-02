package school.faang.comments;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_COUNTER = 4;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNTER);

    public static void main(String[] args) {
        PostService postService = new PostService();
        CompletableFuture<Void> addPosts = CompletableFuture.runAsync(() -> {
            postService.addPost(new Post(1, "Alice", "Hello, world!", "My First Post"));
            postService.addPost(new Post(2, "Bob", "I visited Paris!", "Travel blog"));
            postService.addPost(new Post(3, "Vlad", "I visited Amsterdam", "Travel blog"));


        }, executorService);
        addPosts.join();

        Comment comment = new Comment("Hello,Alice", "Maria",
                LocalDateTime.of(2025, 2, 3, 15, 45));
        Comment comment2 = new Comment("Nice", "Alice",
                LocalDateTime.of(2025, 2, 3, 15, 35));
        CompletableFuture<Void> addComment = CompletableFuture.runAsync(() -> {
            postService.addComment(1, comment);
            postService.addComment(2, comment2);
            postService.removePost(3, "Vlad");
            postService.removeComment(1,
                    LocalDateTime.of(2025, 2, 3, 15, 45), "Alice");

        }, executorService);
        addComment.join();
        postService.showPosts();
        executorService.shutdown();
    }
}

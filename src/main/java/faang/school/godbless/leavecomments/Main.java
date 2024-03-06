package faang.school.godbless.leavecomments;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        PostService service = new PostService();

        CompletableFuture.allOf(addPosts(service).toArray(CompletableFuture[]::new)).join();
        CompletableFuture.allOf(addComments(0, service).toArray(CompletableFuture[]::new)).join();
        System.out.println(service.getPostById(0).get());
        Comment newComment = new Comment("lerhg", LocalDateTime.now(), "Alex");
        CompletableFuture.runAsync(() -> service.addComment(0, newComment), EXECUTOR_SERVICE).join();
        CompletableFuture.runAsync(() -> service.deleteComment(0, newComment, "Alex"), EXECUTOR_SERVICE).join();
        CompletableFuture.runAsync(() -> service.deletePost(0, "Author 0"), EXECUTOR_SERVICE).join();
        System.out.println(service.getPostById(0));

        EXECUTOR_SERVICE.shutdown();
        awaitTermination(5);
    }

    public static List<CompletableFuture<Void>> addComments(long postId, PostService service) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            futures.add(CompletableFuture.runAsync(()
                    -> service.addComment(postId, new Comment(String.format("Comment %d", finalI), LocalDateTime.now(), String.format("Author %d", finalI))), EXECUTOR_SERVICE));
        }
        return futures;
    }

    public static List<CompletableFuture<Void>> addPosts(PostService service) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            futures.add(CompletableFuture.runAsync(() -> service.addPost(new Post(finalI, String.format("Header %d", finalI), "Text", String.format("Author %d", finalI))), EXECUTOR_SERVICE));
        }
        return futures;
    }

    private static void awaitTermination(int minutes) {
        try {
            EXECUTOR_SERVICE.awaitTermination(minutes, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

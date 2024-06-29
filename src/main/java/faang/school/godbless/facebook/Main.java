package faang.school.godbless.facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREAD = 10;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREAD);

    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();
        for (long i = 0; i < 10; i++) {
            posts.add(new Post(i, "Post: " + i, "Post: " + i));
        }
        for (long i = 0; i < 20; i++) {
            comments.add(new Comment(i, "comment: " + i));
        }
        PostService postService = new PostService();
        posts.stream()
                .forEach(post -> {
                    CompletableFuture.runAsync(() -> postService.addPost(post), EXECUTOR)
                            .thenRun(() -> comments.forEach(comment -> postService.addComment(comment, post)))
                            .join();
                });
        EXECUTOR.shutdown();
    }
}

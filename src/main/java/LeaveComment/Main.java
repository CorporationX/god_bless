package LeaveComment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int MAX_EXECUTOR_THREAD = 10;
        PostService postService = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(MAX_EXECUTOR_THREAD);

        executor.submit(() -> postService.addPost(new Post(1, "Fill", "ExecutorService", "text...")));
        executor.submit(() -> postService.addPost(new Post(2, "Masha", "Concurrent", "text...")));
        executor.submit(() -> postService.addPost(new Post(3, "Ira", "Post", "text...")));

        executor.submit(() -> postService.addComment(2, new Comment("Bob", "random comment1...")));
        executor.submit(() -> postService.addComment(1, new Comment("Fill", "random comment2...")));
        executor.submit(() -> postService.addComment(2, new Comment("Misha", "random comment3...")));

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        postService.printPosts();
        postService.printComment();
    }
}
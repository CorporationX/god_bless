package LeaveComment;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int MAX_EXECUTOR_THREAD = 5;
        PostService postService = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(MAX_EXECUTOR_THREAD);

        executor.submit(() -> postService.addPost(new Post(5,"Fill", "ExecutorService", "text...")));
        executor.submit(() -> postService.addPost(new Post(6, "Masha", "Concurrent", "text...")));
        executor.submit(() -> postService.addPost(new Post(7, "Ira", "Post", "text...")));

        executor.awaitTermination(5, TimeUnit.SECONDS);

        executor.submit(() -> postService.addComment(2,new Comment("Bob", "random comment1...", LocalDateTime.now())));
        executor.submit(() -> postService.addComment(3, new Comment("Fill", "random comment2...", LocalDateTime.now())));
        executor.submit(() -> postService.addComment(4, new Comment("Misha", "random comment3...", LocalDateTime.now())));

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        postService.printPosts();
        postService.printComment();
    }
}

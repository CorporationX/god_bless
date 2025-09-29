package school.faang.bjs2_93612;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Post post = new Post();
        Comment comment = new Comment("asd", "adgfs", LocalDateTime.now());
        PostService postService = new PostService();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> postService.addComment(comment));
        executorService.submit(() -> )
    }
}
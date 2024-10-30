package comments;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMBER_OF_THREADS = 7;
    private static final int NUMBER_OF_POSTS = 2;
    private static final int NUMBER_OF_COMMENTS = 5;

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < NUMBER_OF_POSTS; i++) {
            int postId = i;
            executorService.submit(() -> postService.addPost(
                    new Post(postId,
                            "title " + postId,
                            "content " + postId,
                            new User("author " + postId))));

        }

        for (int i = 0; i < NUMBER_OF_COMMENTS; i++) {
            int postId = i % NUMBER_OF_POSTS;
            executorService.submit(() -> postService.addComment(
                    postId,
                    new Comment("text " + postId,
                            new User("author " + postId),
                            LocalDateTime.now())));
        }

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        for (int i = 0; i < NUMBER_OF_POSTS; i++) {
            System.out.println(postService.getComments(i));
        }
    }
}

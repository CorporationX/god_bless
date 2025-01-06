package school.faang.task_51263;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 8;

    private static final int NUM_AUTHORS = 10;
    private static final int NUM_POSTS = 20;

    private static final int MAX_RANDOM_COMMENTS = 10;
    private static final int MAX_RANDOM_MINUTES = 100;

    private static final int TERMINATION_TIMEOUT_MILLIS = 10;

    private static final List<String> AUTHORS;
    private static final List<Post> POSTS;

    static {
        AUTHORS = IntStream.rangeClosed(1, NUM_AUTHORS)
                .mapToObj(i -> String.format("Author %d", i))
                .toList();


        POSTS = IntStream.rangeClosed(1, NUM_POSTS)
                .mapToObj(i ->
                        new Post(i, "title", "content", getRandomAuthor())
                )
                .toList();
    }

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);


        POSTS.forEach(post -> CompletableFuture
                .supplyAsync(() -> {
                    postService.addPost(post);

                    List<Comment> comments = getRandomComments();
                    comments.forEach(comment ->
                            postService.addComment(post.getId(), comment)
                    );

                    return post;
                }, executorService)
                .thenAccept(addedPost -> {
                    List<Comment> comments = addedPost.getComments();
                    comments.forEach(comment ->
                            postService.deleteComment(addedPost.getId(), comment.timestamp(), comment.author())
                    );

                    postService.deletePost(addedPost.getId(), post.getAuthor());
                })
        );

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(TERMINATION_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)) {
                log.info("All tasks completed successfully.");
            } else {
                log.warn("Some tasks did not finish in the allotted time.");
            }
        } catch (InterruptedException e) {
            log.error("Waiting for termination was interrupted.", e);
            executorService.shutdownNow();
        }
    }

    private static List<Comment> getRandomComments() {
        return IntStream.range(0, (int) (Math.random() * MAX_RANDOM_COMMENTS))
                .mapToObj(i -> new Comment("comment", getRandomAuthor(), getRandomTimestamp()))
                .toList();
    }

    private static String getRandomAuthor() {
        int index = (int) (Math.random() * AUTHORS.size());
        return AUTHORS.get(index);
    }

    private static LocalDateTime getRandomTimestamp() {
        return LocalDateTime.now().minusMinutes((long) (Math.random() * MAX_RANDOM_MINUTES));
    }

}

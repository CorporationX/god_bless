package school.faang.multithreading.concurr.leave.comment;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        IntStream.rangeClosed(1, 10)
                .forEach(i -> {
                    executorService.execute(() ->
                            postService.addPost(new Post(i, "Title" + i, "Content" + i, "Author" + i, new ArrayList<>())));
                });

        IntStream.rangeClosed(1, 10).forEach(postId -> {
            IntStream.rangeClosed(1, 10).forEach(commentId -> {
                executorService.execute(() -> {
                    Comment comment = new Comment("Text" + commentId, "Author" + commentId, LocalDateTime.now());
                    postService.addComment(postId, comment);
                });
            });
        });

        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            IntStream.rangeClosed(1, 10).forEach(postId -> {
                postService.showPost(postId).ifPresent(post -> {
                    log.info("Пост: {}", post.getTitle());
                    post.getComments().forEach(comment -> log.info(" - " + comment.getText()));
                });
            });
        });

        executorService.shutdown();
    }
}

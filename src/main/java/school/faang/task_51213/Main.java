package school.faang.task_51213;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int THREAD_NUM = 5;
    private static final int USERS_NUM = 200;

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);

        List<CompletableFuture<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < USERS_NUM; i++) {
            int finalI = i;
            tasks.add(CompletableFuture.runAsync(() -> {
                Comment newComment = new Comment(finalI,
                        "text comment" + finalI,
                        "author" + finalI,
                        LocalDateTime.now());
                Post newPost = new Post(finalI,
                        "title" + finalI,
                        "content" + finalI,
                        "author" + finalI);
                postService.addPost(newPost);
                postService.addComment(finalI, newComment);
                postService.viewAllComments(finalI);
                if (finalI % 2 == 0) {
                    postService.deletePost(finalI, newPost.getAuthor());
                }
                if (finalI % 3 == 0) {
                    postService.deleteComment(finalI, newComment);
                }
            }, executor));
        }
        executor.shutdown();
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]));

        try {
            allTasks.get();
            postService.viewAllPosts();
        } catch (InterruptedException | ExecutionException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            log.info("Поток был прерван при вызове метода get()", e);
        }
    }
}

package task16;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Post post = new Post(123L, "Заголовок1", " текст", new ArrayList<>());
        Comment commentOne = new Comment(134L, "комментарий1", new Date(), "Автор1");
        Comment commentTwo = new Comment(135L, "комментарий2", new Date(), "Автор2");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> post.addComment(commentOne));
        executor.execute(() -> post.addComment(commentTwo));
        PostService postService = new PostService(new ArrayList<>());
        executor.shutdown();
        while (!executor.isTerminated()) {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        CompletableFuture<Void> completableFuture3 = CompletableFuture.supplyAsync(() -> {
            postService.addPost(post);
            return null;
        });
        completableFuture3.join();
        System.out.println("Успешно!");
    }
}
package facebook;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static int THREAD_COUNT = 3;

    public static void main(String[] args) {
        PostServis postServis = new PostServis();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        Post post1 = new Post(1, "Java Multithreading", "This is a post about multithreading in Java.", "Alice");
        Post post2 = new Post(2, "Introduction to Spring", "This post covers the basics of Spring framework.", "Bob");
        Post post3 = new Post(3, "Java", "This is a post", "Olya");

        CompletableFuture<Void> futurePost1 = CompletableFuture.runAsync(() -> postServis.addPost(post1), executorService);
        CompletableFuture<Void> futurePost2 = CompletableFuture.runAsync(() -> postServis.addPost(post2), executorService);
        CompletableFuture<Void> futurePost3 = CompletableFuture.runAsync(() -> postServis.addPost(post3), executorService);

        Comment comment1 = new Comment("Great post!", "Tolya");
        Comment comment2 = new Comment("I found this very helpful.", "Kolya");
        Comment comment3 = new Comment("Good introduction.", "Nick");

        CompletableFuture<Void> future1Comment1 = CompletableFuture.runAsync(() -> postServis.addComment(1, comment1), executorService);
        CompletableFuture<Void> future1Comment2 = CompletableFuture.runAsync(() -> postServis.addComment(1, comment2), executorService);
        CompletableFuture<Void> future2Comment3 = CompletableFuture.runAsync(() -> postServis.addComment(2, comment3), executorService);
        CompletableFuture<Void> futureShowPost = CompletableFuture.allOf(futurePost1, futurePost2, futurePost3, future1Comment2, future1Comment1, future2Comment3)
                .thenRun(() -> {
                    System.out.println("All posts and comments:");
                    postServis.showPosts();
                });
        CompletableFuture<Void> futureRemoveComment = futureShowPost
                .thenRun(() -> {
                    System.out.println("Removing comment 'Great post!' from post 1");
                    postServis.remooveComment(1, "Great post!");
                });

        CompletableFuture<Void> futureRemovePost = futureRemoveComment
                .thenRun(() -> {
                    System.out.println("Removing post 1");
                    postServis.removePost(1);
                });
        CompletableFuture<Void> allFuture = CompletableFuture.allOf(futureRemoveComment, futureRemovePost);
        allFuture.join();
        System.out.println("Post after all operation: ");
        postServis.showPosts();
        executorService.shutdown();
    }
}


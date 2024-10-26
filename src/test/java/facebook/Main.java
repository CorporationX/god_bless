package facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static int THREAD_COUNT = 3;

    public static void main(String[] args) {
        PostServis postServis = new PostServis();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        String[] titles = {"Java Multithreading", "Introduction to Spring", "Java"};
        String[] contents = {
                "This is a post about multithreading in Java.",
                "This post covers he basics of Spring framework.",
                "This is a post"
        };
        String[] authors = {"Alice", "Bob", "Olya"};
        List<Post> posts = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            posts.add(new Post(i + 1, titles[i], contents[i], authors[i]));
        }
        List<CompletableFuture<Void>> postFutures = posts.stream()
                .map(post -> CompletableFuture.runAsync(() -> postServis.addPost(post), executorService))
                .toList();
        Comment[] comments = {
                new Comment("Great post!", "Tolya"),
                new Comment("I found this very helpful.", "Kolya"),
                new Comment("Good introduction.", "Nick")
        };
        int[] postIds = {1, 1, 2};
        List<CompletableFuture<Void>> commentFutures = new ArrayList<>();
        for (int i = 0; i < comments.length; i++) {
            int postId = postIds[i];
            int index = i;
            commentFutures.add(CompletableFuture.runAsync(() -> postServis.addComment(postId, comments[index]), executorService));
        }
        CompletableFuture<Void> futureShowPost = CompletableFuture.allOf(commentFutures.toArray(new CompletableFuture[0]))
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


package faang.school.godbless.bjs2_6023;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final long POST_ID = 1L;
    private static final long COMMENT_ID_REMOVE = 1L;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        PostService postService = new PostService();

        //Users
        String ivanov = "Ivanov";
        String petrov = "Petrov";
        String sidorov = "Sidorov";

        Post ivanovPost = new Post(1, "Concurrency", "Concurrency is difficult for newbie", ivanov);
        List<Comment> comments = List.of(new Comment(1, "Yes, it's true", petrov),
                new Comment(2, "I think they need to read 'Concurrency in practice'", sidorov),
                new Comment(3, "It's not so difficult if you learn Java a lot", ivanov));

        postService.addPost(ivanovPost);

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        //Create futures for comments
        comments.forEach(comment -> CompletableFuture.runAsync(() -> postService.addComment(POST_ID, comment), executorService));

        //Join all futures
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        Thread.sleep(5000);
        //Print all comments for post with ID = 1
        postService.printCommentForPost(POST_ID);

        //Print post
        postService.printPost(POST_ID);

        //Remove post
        postService.removePost(POST_ID, petrov);
        postService.printPost(POST_ID);

        //Remove comment
        postService.removeCommentFromPost(POST_ID, COMMENT_ID_REMOVE, petrov);
        postService.printCommentForPost(POST_ID);

        executorService.shutdown();

        System.out.println("Finished");
    }
}

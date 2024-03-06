package faang.school.godbless.comments;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        PostService postService = new PostService();
        CompletableFuture.allOf(addPosts(postService).toArray(CompletableFuture[]::new)).join();
        CompletableFuture.allOf(addComments(postService).toArray(CompletableFuture[]::new)).join();
        System.out.println(postService.getPostById(1).get());
        Comment newComment = new Comment("some text", LocalDateTime.now(), "Vasya");
        CompletableFuture.runAsync(() -> postService.addComment(1, newComment), EXECUTOR_SERVICE).join();
        CompletableFuture.runAsync(() -> postService.deleteComment(1, newComment, "Vasya"), EXECUTOR_SERVICE).join();
        CompletableFuture.runAsync(() -> postService.deletePost(1, "Petya"), EXECUTOR_SERVICE).join();
        System.out.println(postService.getPostById(1));

        EXECUTOR_SERVICE.shutdown();
        try {
            EXECUTOR_SERVICE.awaitTermination(600, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        postService.viewComments(0);

    }

    private static List<CompletableFuture<Void>> addComments(PostService postService) {
        List<CompletableFuture<Void>> comments = new ArrayList<>();
        comments.add(CompletableFuture.runAsync(() -> postService.addComment(1, new Comment("ha-ha", LocalDateTime.now(), "Vasya Pupkin")), EXECUTOR_SERVICE));
        comments.add(CompletableFuture.runAsync(() -> postService.addComment(1, new Comment("ha-ha-ha", LocalDateTime.now(), "Vasya Pupkin")), EXECUTOR_SERVICE));
        comments.add(CompletableFuture.runAsync(() -> postService.addComment(2, new Comment("bullshit", LocalDateTime.now(), "Vasya Pupkin")), EXECUTOR_SERVICE));
        comments.add(CompletableFuture.runAsync(() -> postService.addComment(3, new Comment("well done", LocalDateTime.now(), "Vasya Pupkin")), EXECUTOR_SERVICE));
        return comments;
    }

    private static List<CompletableFuture<Void>> addPosts(PostService postService) {
        List<CompletableFuture<Void>> posts = new ArrayList<>();
        posts.add(CompletableFuture.runAsync(() -> postService.addPost(new Post(0, "header1", "some text", "Elon Musk")), EXECUTOR_SERVICE));
        posts.add(CompletableFuture.runAsync(() -> postService.addPost(new Post(1, "header2", "some important text", "Elon Musk")), EXECUTOR_SERVICE));
        posts.add(CompletableFuture.runAsync(() -> postService.addPost(new Post(2, "header3", "some very important text", "Elon Musk")), EXECUTOR_SERVICE));
        posts.add(CompletableFuture.runAsync(() -> postService.addPost(new Post(3, "No header", "text", "Vasya Pupkin")), EXECUTOR_SERVICE));
        return posts;
    }

}

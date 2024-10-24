package bjs2_37887;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        PostService postService = new PostService();

        List<Comment> firstPostComments = new ArrayList<>() {{
            add(new Comment("Great insight!", "John Johnaton"));
            add(new Comment("...", "Jack Jackson"));
        }};
        List<Comment> secondPostComments = new ArrayList<>() {{
            add(new Comment("Thats hilarious!", "Bob"));
            add(new Comment("Damn...", "Steve"));
            add(new Comment("Thats crazy...", "George"));
        }};
        List<Comment> thirdPostComments = new ArrayList<>() {{
            add(new Comment("Who would've thought", "Jason"));
        }};

        Post firstPost = new Post(0, "10 facts about cats",
                "Some content", "Some author", firstPostComments);
        Post secondPost = new Post(1, "Try not to laugh",
                "Some funny content", "Bob", secondPostComments);
        Post thirdPost = new Post(2, "Java Multithreading made easy",
                "Some educational content", "Vlad", thirdPostComments);

        CompletableFuture<Void> addFirstPost = CompletableFuture
                .runAsync(() -> postService.addPost(firstPost), executorService);
        CompletableFuture<Void> addSecondPost = CompletableFuture
                .runAsync(() -> postService.addPost(secondPost), executorService);
        CompletableFuture<Void> addThirdPost = CompletableFuture
                .runAsync(() -> postService.addPost(thirdPost), executorService);

        CompletableFuture.allOf(addFirstPost, addSecondPost, addThirdPost).join();

        postService.viewPosts();
        System.out.println();

        CompletableFuture<Void> firstPostAddComment = CompletableFuture
                .runAsync(() -> postService.addComment(0, new Comment("wow", "Sam")));
        CompletableFuture<Void> secondPostDeleteComment = CompletableFuture
                .runAsync(() -> postService.deleteComment(1, secondPostComments.get(1),
                        secondPostComments.get(1).getAuthor()));
        CompletableFuture<Void> thirdPostDelete = CompletableFuture
                .runAsync(() -> postService.deletePost(2, thirdPost.getAuthor()));
        CompletableFuture<Void> invalidDeleteComment = CompletableFuture
                .runAsync(() -> postService.deleteComment(0,
                firstPost.getComments().get(0), "Invalid author"));
        CompletableFuture<Void> invalidDeletePost = CompletableFuture
                .runAsync(() -> postService.deletePost(0, "Invalid author"));

        CompletableFuture.allOf(firstPostAddComment, secondPostDeleteComment, thirdPostDelete,
                invalidDeletePost, invalidDeleteComment).join();

        postService.viewPosts();

        executorService.shutdown();
    }
}

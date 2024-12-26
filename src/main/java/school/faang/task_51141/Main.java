package school.faang.task_51141;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        CompletableFuture<Void> post1 = CompletableFuture.runAsync(() -> {
            Post post = postService.addPost("First Post", "Content of the first post", "User1");
            System.out.println("Post added: " + post.getTitle());
        });

        CompletableFuture<Void> post2 = CompletableFuture.runAsync(() -> {
            Post post = postService.addPost("Second Post", "Content of the second post", "User2");
            System.out.println("Post added: " + post.getTitle());
        });

        CompletableFuture<Void> comment1 = CompletableFuture.runAsync(() -> {
            Comment comment = new Comment("Great post!", "User3", LocalDateTime.now());
            postService.addComment(0, comment);
            System.out.println("Comment added to Post 1: " + comment.getText());
        });

        CompletableFuture<Void> comment2 = CompletableFuture.runAsync(() -> {
            Comment comment = new Comment("Nice post!", "User4", LocalDateTime.now());
            postService.addComment(1, comment);
            System.out.println("Comment added to Post 2: " + comment.getText());
        });

        CompletableFuture.allOf(post1, post2, comment1, comment2).join();

        System.out.println("Final list of posts:");
        postService.getPosts().forEach((id, post) -> {
            System.out.println(post.getTitle() + " by " + post.getAuthor());
            post.getComments().forEach(comment ->
                    System.out.println("  - Comment: " + comment.getText() + " by " + comment.getAuthor())
            );
        });
    }
}

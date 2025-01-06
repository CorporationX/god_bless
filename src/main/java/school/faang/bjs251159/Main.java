package school.faang.bjs251159;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        PostService postService = new PostService();

        Comment commentA = new Comment("Author1", "Comment_text1", LocalDateTime.now());
        Comment commentB = new Comment("Author2", "Comment_text2", LocalDateTime.now());
        Comment commentC = new Comment("Author3", "Comment_text3", LocalDateTime.now());

        Post postA = new Post(0, "AuthorA", "TitleA", "ContentA");
        Post postB = new Post(1, "AuthorB", "TitleB", "ContentB");

        CompletableFuture<Void> post1 = CompletableFuture.runAsync(() -> postService.addPost(postA));

        CompletableFuture<Void> post2 = CompletableFuture.runAsync(() -> postService.addPost(postB));

        CompletableFuture<Void> comment1 = CompletableFuture.runAsync(() ->
                postService.addComment(0, commentA));

        CompletableFuture<Void> comment2 = CompletableFuture.runAsync(() ->
                postService.addComment(1, commentB));

        CompletableFuture<Void> comment3 = CompletableFuture.runAsync(() ->
                postService.addComment(1, commentC));

        CompletableFuture.allOf(post1, post2, comment1, comment2, comment3).join();
        postService.printPosts();
    }
}
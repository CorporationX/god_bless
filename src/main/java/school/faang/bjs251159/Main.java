package school.faang.bjs251159;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        PostService postService = new PostService();

        List<Comment> comments = Arrays.asList(
                new Comment("Author1", "Comment_text1", LocalDateTime.now()),
                new Comment("Author2", "Comment_text2", LocalDateTime.now()),
                new Comment("Author3", "Comment_text3", LocalDateTime.now())
        );

        List<Post> posts = Arrays.asList(
                new Post(0, "AuthorA", "TitleA", "ContentA"),
                new Post(1, "AuthorB", "TitleB", "ContentB")
        );

        List<CompletableFuture<Void>> futures = posts.stream()
                .map(post -> CompletableFuture.runAsync(() -> postService.addPost(post)))
                .collect(Collectors.toList());

        futures.addAll(comments.stream()
                .map(comment -> CompletableFuture.runAsync(() -> {
                    int postId = comment.hashCode() % 2;
                    postService.addComment(postId, comment);
                }))
                .toList());

/*      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        CompletableFuture<Void> post1 = CompletableFuture.runAsync(() -> postService.addPost(postA));
        CompletableFuture<Void> post2 = CompletableFuture.runAsync(() -> postService.addPost(postB));

        CompletableFuture<Void> comment1 = CompletableFuture.runAsync(() ->
                postService.addComment(0, commentA));
        CompletableFuture<Void> comment2 = CompletableFuture.runAsync(() ->
                postService.addComment(1, commentB));
        CompletableFuture<Void> comment3 = CompletableFuture.runAsync(() ->
                postService.addComment(1, commentC));

        CompletableFuture.allOf(post1, post2, comment1, comment2, comment3).join();*/

        postService.printPosts();
    }
}
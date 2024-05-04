package faang.school.godbless.BJS2_6189;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Post post1 = new Post(1, "Cars", "Do you love cars?", "Terri");
        Post post2 = new Post(2, "Sport", "What kind of sport do you like?", "Matheu");

        Comment comment1 = new Comment("Yes, I have volvo", LocalDateTime.now(), "Kevin");
        Comment comment2 = new Comment("Yes I have red car", LocalDateTime.now(), "John");
        Comment comment3 = new Comment("No", LocalDateTime.now(), "Donald");
        Comment comment4 = new Comment("Yes", LocalDateTime.now(), "Artur");
        Comment comment5 = new Comment("Golf", LocalDateTime.now(), "Rambo");
        Comment comment6 = new Comment("Running", LocalDateTime.now(), "Mat");
        Comment comment7 = new Comment("Swimming", LocalDateTime.now(), "Paul");
        Comment comment8 = new Comment("Chess", LocalDateTime.now(), "Peter");

        PostService postService = new PostService();

        postService.addPost(post1);
        postService.addPost(post2);

        CompletableFuture<Void> addComment1Future = CompletableFuture.runAsync(
                () -> postService.addComment(post1, comment1));
        CompletableFuture<Void> addComment2Future = CompletableFuture.runAsync(
                () -> postService.addComment(post1, comment2));
        CompletableFuture<Void> addComment3Future = CompletableFuture.runAsync(
                () -> postService.addComment(post1, comment3));
        CompletableFuture<Void> addComment4Future = CompletableFuture.runAsync(
                () -> postService.addComment(post1, comment4));
        CompletableFuture<Void> addComment5Future = CompletableFuture.runAsync(
                () -> postService.addComment(post2, comment5));
        CompletableFuture<Void> addComment6Future = CompletableFuture.runAsync(
                () -> postService.addComment(post2, comment6));
        CompletableFuture<Void> addComment7Future = CompletableFuture.runAsync(
                () -> postService.addComment(post2, comment7));
        CompletableFuture<Void> addComment8Future = CompletableFuture.runAsync(
                () -> postService.addComment(post2, comment8));

        CompletableFuture<Void> deleteComment1Future = CompletableFuture.runAsync(
                () -> postService.deleteComment(post1, comment1, "Kevin"));

        CompletableFuture<Void> deleteComment2Future = CompletableFuture.runAsync(
                () -> postService.deleteComment(post2, comment5, "Rambo"));

        CompletableFuture<Void> deletePostFuture = CompletableFuture.runAsync(
                () -> postService.deletePost(post1, "Mike"));

        List<CompletableFuture<Void>> futures = List.of(
                addComment1Future,
                addComment2Future,
                addComment3Future,
                addComment4Future,
                addComment5Future,
                addComment6Future,
                addComment7Future,
                addComment8Future,
                deleteComment1Future,
                deleteComment2Future,
                deletePostFuture
        );

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println(postService);

        CompletableFuture.runAsync(() -> System.out.println(postService.getPosts())).join();
        System.out.println("\n");
        CompletableFuture.runAsync(() -> System.out.println(postService.getComments(post1))).join();
    }
}

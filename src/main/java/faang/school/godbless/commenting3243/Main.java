package faang.school.godbless.commenting3243;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static List<Comment> testComments = new ArrayList<>();
    static final Random RANDOM = new Random();
    static final List<Post> POSTS = new ArrayList<>(List.of(
            new Post("Test post #1", "Yeah, im hardcoding tests:)", "hhzktoeto"),
            new Post("Test post #2", "I ain't even feel bad", "hhz")
    ));
    static final PostService POST_SERVICE = new PostService();
    static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        CompletableFuture<Void> futureCommentsCreated = CompletableFuture.runAsync(Main::fillCommentsList, EXECUTOR);
        CompletableFuture<Void> futurePostsAdded = CompletableFuture.runAsync(
                () -> POSTS.forEach(post -> EXECUTOR.execute(() -> POST_SERVICE.addPost(post))), EXECUTOR);
        CompletableFuture.allOf(futureCommentsCreated, futurePostsAdded)
                .thenRun(() -> POSTS.forEach(post -> {
                    EXECUTOR.execute(() -> POST_SERVICE.addPost(post));
                    EXECUTOR.execute(() -> testComments.forEach(comment -> POST_SERVICE.addComment(comment, post)));
                }))
                .thenRun(() -> System.out.println(POST_SERVICE.getPosts()))
                .join();
        CompletableFuture.runAsync(() -> POST_SERVICE.deletePost(POSTS.get(0), "hhz"), EXECUTOR).join();
        CompletableFuture.runAsync(() -> POST_SERVICE.deletePost(POSTS.get(0), "hhzktoeto"), EXECUTOR)
                .thenRun(() -> System.out.println(POST_SERVICE.getPosts())).join();
        CompletableFuture.runAsync(() -> POST_SERVICE.deleteComment(testComments.get(7), POSTS.get(0), "hhz"))
                .thenRun(EXECUTOR::shutdown);
    }

    private static void fillCommentsList() {
        String[] authors = {"hhzktoeto", "hhz"};
        for (int i = 1; i <= 10; i++) {
            testComments.add(new Comment(
                    "Test comment #" + i,
                    LocalDateTime.of(2023,
                            RANDOM.nextInt(11) + 1,
                            RANDOM.nextInt(27) + 1,
                            RANDOM.nextInt(22) + 1,
                            RANDOM.nextInt(59) + 1,
                            RANDOM.nextInt(58) + 1),
                    authors[RANDOM.nextInt(2)]));
        }
    }
}

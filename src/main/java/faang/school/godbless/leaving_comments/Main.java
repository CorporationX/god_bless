package faang.school.godbless.leaving_comments;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static final int THREAD_NUM = 10;
    public static final PostService postService = new PostService();
    public static final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);


    public static void main(String[] args) {
        List<Post> postList = getPostList();
        addPostsAsynchronously(postList).join();

        List<Comment> commentList = getCommentList();
        addCommentsAsynchronously(commentList).join();

        postService.showAllPosts();

        deletePostAsynchronously("BoxMaster",
                new Post(1, "Box", "WhoWillWin", "BoxMaster", new ArrayList<>())
        ).join();

        postService.showAllPosts();
        executorService.shutdown();
    }

    private static CompletableFuture<Void> deletePostAsynchronously(String personDeletingPostName, Post postToDelete) {
        return CompletableFuture.runAsync(() ->
                        postService.deletePost(personDeletingPostName, postToDelete),
                executorService);
    }

    private static CompletableFuture<Void> addCommentsAsynchronously(List<Comment> commentList) {
        List<CompletableFuture<Void>> commentAddingFutureList = new ArrayList<>();

        commentList.forEach(comment -> commentAddingFutureList.add(
                        CompletableFuture.runAsync(() ->
                                        postService.addComment(ThreadLocalRandom.current().nextInt(1,
                                                Post.postsCounter + 1), comment),
                                executorService)
                )
        );

        return CompletableFuture.allOf(commentAddingFutureList.toArray(CompletableFuture[]::new));
    }

    private static CompletableFuture<Void> addPostsAsynchronously(List<Post> postList) {
        List<CompletableFuture<Void>> postAddingFutureList = new ArrayList<>();

        postList.forEach(post -> postAddingFutureList.add(
                        CompletableFuture.runAsync(() -> postService.addPost(post), executorService)
                )
        );

        return CompletableFuture.allOf(postAddingFutureList.toArray(CompletableFuture[]::new));
    }

    private static List<Post> getPostList() {
        return List.of(
                new Post(1, "Box", "WhoWillWin", "BoxMaster", new ArrayList<>()),
                new Post(2, "Technology", "NewPhone", "TechMaster", new ArrayList<>()),
                new Post(3, "Health", "BeHealthy", "HealthMaster", new ArrayList<>()),
                new Post(4, "Philosophy", "HowToMind", "PhilosophyMaster", new ArrayList<>()),
                new Post(5, "Math", "HowToIntegrate", "MathMaster", new ArrayList<>()),
                new Post(6, "Business", "HowToMakeMoney", "BuninessMaster", new ArrayList<>())
        );
    }

    private static List<Comment> getCommentList() {
        return List.of(
                new Comment("Cool", LocalDateTime.now(), "FirstAuthor"),
                new Comment("Awesome", LocalDateTime.now(), "SecondAuthor"),
                new Comment("Good", LocalDateTime.now(), "ThirdAuthor"),
                new Comment("Not Bad", LocalDateTime.now(), "FourthAuthor"),
                new Comment("Normal", LocalDateTime.now(), "FifthAuthor"),
                new Comment("Excellent", LocalDateTime.now(), "SixthAuthor")
        );
    }
}

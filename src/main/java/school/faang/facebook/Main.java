package school.faang.facebook;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        final int POST_COUNT = 3;
        List<Post> posts = new ArrayList<>();
        for (int i = 1; i <= POST_COUNT; i++) {
            posts.add(new Post(i, "Title" + i, "Content" + i, "Author" + i));
        }

        PostService postService = new PostService();
        ExecutorService executor = Executors.newCachedThreadPool();
        List<CompletableFuture<Void>> futureTasks = new ArrayList<>();
        for (Post post : posts) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> postService.addPost(post), executor)
                    .thenRunAsync(() -> postService.addComment(post.getId(), new Comment(post.getTitle() + "-TextA", "Author1", LocalDateTime.now())), executor)
                    .thenRunAsync(() -> postService.addComment(post.getId(), new Comment(post.getTitle() + "-TextB", "Author2", LocalDateTime.now())), executor)
                    .thenRunAsync(() -> postService.readPost(post.getId()), executor)
                    .thenRunAsync(() -> postService.deleteComment(post.getId(), "Author2"), executor);
            futureTasks.add(future);
        }
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futureTasks.toArray(new CompletableFuture[0]));
        allFutures.thenRunAsync(() -> postService.deletePost(1, "Author1"), executor).join();
        allFutures.join();

        executor.shutdown();

        System.out.println("List of posts after all tasks finished:");
        postService.getPosts().forEach(System.out::println);
    }
}

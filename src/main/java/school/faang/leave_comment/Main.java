package school.faang.leave_comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        Random random = new Random();
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<CompletableFuture<Post>> completableFutureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int indexId = i;
            CompletableFuture<Post> future = CompletableFuture.supplyAsync(() -> {
                Post post = new Post(indexId, "title" + indexId, "content" + indexId, new ArrayList<>());
                postService.addPost(post);
                for (int j = 0; j < random.nextInt(2, 5); j++) {
                    postService.addComment(indexId,
                            new Comment(j, "textComment" + j, "author" + j, LocalDateTime.now()));
                }
                return post;
            }, service);
            completableFutureList.add(future);
        }

        CompletableFuture<Void> allOf =
                CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));
        allOf.join();

        service.shutdown();
        postService.printAllPosts();
    }
}

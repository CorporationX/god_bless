package faang.school.godbless.FourthSprint.bjs2_51333;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<User> authors = new ArrayList<>();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        PostService postService = new PostService();

        for (int i = 0; i < 5; i++) {
            authors.add(new User(i, "user #" + i));
        }
        for (int i = 0; i < authors.size(); i++) {
            int finalI = i;
            futures.add(CompletableFuture
                    .runAsync(() -> postService.addPost(
                                    new Post(finalI, Thread.currentThread().toString()
                                            , "Content"
                                            , authors.get(finalI)))
                            , executor));
        }

        for (int i = 0; i < authors.size(); i++) {
            int randomPostId = ThreadLocalRandom.current().nextInt(0, authors.size());
            int randomAuthorId = ThreadLocalRandom.current().nextInt(0, authors.size());
            futures.add(CompletableFuture
                    .runAsync(() -> postService.addComment(randomPostId
                                    , new Comment(Thread.currentThread().toString()
                                            , authors.get(randomAuthorId)
                                            , LocalDateTime.now()))
                            , executor));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();

        postService.getPosts().stream().forEach(System.out::println);
    }
}

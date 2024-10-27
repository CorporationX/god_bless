package school.faang.task421;

import school.faang.task421.comment.Comment;
import school.faang.task421.post.Post;
import school.faang.task421.post.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Post firstPost = new Post(0, "Зоопарк", "Текст про зоопарк", "Иван");
        Post secondPost = new Post(1, "Аквапарк", "Текст про аквапарк", "Игорь");
        Post thirdPost = new Post(2, "Что то", "Текст про что-то", "Кто-то");

        ExecutorService service = Executors.newFixedThreadPool(6);
        PostService postService = new PostService();

        List<CompletableFuture<Void>> futures = Stream.of(firstPost, secondPost, thirdPost)
                .map(post -> CompletableFuture.runAsync(() -> postService.addPost(post)))
                .toList();

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();

        List<CompletableFuture<Void>> secondFutures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            secondFutures.add(CompletableFuture.runAsync(() -> {
                for (int j = 0; j < 3; j++) {
                    postService.addComment(j, new Comment("some text", "name " + finalI));
                }
            }, service));
        }

        allOf = CompletableFuture.allOf(secondFutures.toArray(new CompletableFuture[0]));
        allOf.join();

        postService.printAllPost();

        for (int i = 0; i < 5; i++) {
            postService.deleteComment("name " + i, 1);
        }
        postService.printAllPost();

        for (int i = 0; i < 5; i++) {
            postService.deleteComment("name " + i, 2);
        }
        postService.printAllPost();

        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Ошибка");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}

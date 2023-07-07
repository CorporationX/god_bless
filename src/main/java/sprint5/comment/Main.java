package sprint5.comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int POSTS_COUNT = 3;
    private static final int COMMENTS_COUNT = 6;
    private static final int COMMENTS_TO_POST = 2;

    public static void main(String[] args) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        PostService service = new PostService();

        for (int i = 0; i < POSTS_COUNT; i++) {
            Post post = new Post("" + i, "text¹" + i, "User" + i);
            futures.add(CompletableFuture.runAsync(() -> {
                anyUserActivity();
                service.addPost(post);
            }));
        }

        for (int i = 0; i < COMMENTS_COUNT; i++) {
            Comment comment = new Comment("Message¹" + i, LocalDateTime.now(), "User" + i);
            int finalI = i;
            futures.add(CompletableFuture.runAsync(() -> {
                anyUserActivity();
                service.addComment(finalI / 2, comment);
            }));
        }

        for (int i = 0; i < COMMENTS_COUNT; i++) {
            int finalI = i;
            futures.add(CompletableFuture.runAsync(() -> {
                anyUserActivity();
                service.deleteComment(finalI / COMMENTS_TO_POST, "User" + finalI);
            }));
        }

        for (int i = 0; i < POSTS_COUNT; i++) {
            int finalI = i;
            futures.add(CompletableFuture.runAsync(() -> {
                anyUserActivity();
                service.deletePost(finalI);
            }));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Work done");
        System.out.println(service.getPosts());
    }


    private static void anyUserActivity() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

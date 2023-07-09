package sprint5.comment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int POSTS_COUNT = 3;
    private static final int COMMENTS_COUNT = 6;
    private static final int COMMENTS_TO_POST = 2;
    private static final List<CompletableFuture<Void>> FUTURES = new ArrayList<>();

    public static void main(String[] args) {
        PostService service = new PostService();

        for (int i = 0; i < POSTS_COUNT; i++) {
            Post post = new Post("" + i, "text№" + i, "User" + i);
            FUTURES.add(CompletableFuture.runAsync(() -> {
                anyUserActivity();
                service.addPost(post);
            }));
        }
        waitForThreadsToEnd();

        for (int i = 0; i < COMMENTS_COUNT; i++) {
            Comment comment = new Comment("Message№" + i, LocalDateTime.now(), "User" + i);
            int finalI = i;
            FUTURES.add(CompletableFuture.runAsync(() -> {
                anyUserActivity();
                service.addComment(finalI / 2, comment);
            }));
        }
        waitForThreadsToEnd();

        for (int i = 0; i < COMMENTS_COUNT; i++) {
            int finalI = i;
            FUTURES.add(CompletableFuture.runAsync(() -> {
                anyUserActivity();
                service.deleteComment(finalI / COMMENTS_TO_POST, "User" + finalI);
            }));
        }
        waitForThreadsToEnd();

        for (Post post : service.getPosts()) {
            FUTURES.add(CompletableFuture.runAsync(() -> {
                anyUserActivity();
                service.deletePost(post);
            }));
        }

        waitForThreadsToEnd();
        System.out.println("Work done");
        System.out.println(service.getPosts());
    }

    private static void waitForThreadsToEnd() {
        CompletableFuture.allOf(FUTURES.toArray(new CompletableFuture[0])).join();
    }

    private static void anyUserActivity() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package faang.school.godbless.comments;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private final static ExecutorService SERVICE = Executors.newFixedThreadPool(20);
    private final static int NUM_OF_POSTS = 10;
    private final static int NUM_OF_COMMENTS = 20;

    public static void main(String[] args) {
        PostService postService = new PostService();

        for (int i = 0; i < NUM_OF_POSTS; i++) {
            int finalI = i;
            CompletableFuture.runAsync(() -> postService.addPost((new Post("Post " + finalI, "Text " + finalI, "Author " + finalI))), SERVICE).join();
            for (int j = 0; j < NUM_OF_COMMENTS; j++) {
                int finalJ = j;
                SERVICE.execute(() -> postService.addComment(new Comment("Text" + finalJ, "Author" + finalJ), postService.getPosts().get(finalI)));
            }
        }
        SERVICE.shutdown();
    }
}


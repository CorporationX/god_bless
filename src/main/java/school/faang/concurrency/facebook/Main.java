package school.faang.concurrency.facebook;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        PostService service = new PostService();
        for (int i = 0; i < 10; i++) {
            Post post = new Post(i, "post name " + i, "test content", "user name" + i);
            Comment comment = new Comment("Comment number " + i, "user name " + i);
            CompletableFuture.supplyAsync(() -> {
                service.addPost(post);
                service.addComment(post.getId(), comment);
                return null;
            }, executor).join();
        }
        executor.shutdown();

        service.allPosts();
        service.showComments(1);

        service.deletePost(1, "Kiril");
        service.allPosts();
    }

}

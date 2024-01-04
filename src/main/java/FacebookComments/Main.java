package FacebookComments;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService();

        ExecutorService commentExecutorService = Executors.newFixedThreadPool(50);
        ExecutorService postExecutorService = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 50; i++) {
            int randomInt = (int) (Math.random()*100);

            commentExecutorService.submit(() -> postService.addComment(
                    (int) (Math.random() * postService.getPosts().size()), new Comment("Text" + randomInt, "Author" + randomInt)));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            postExecutorService.submit(() -> postService.addPost(
                    new Post("Name"+randomInt, "Text"+randomInt, "Author"+randomInt)));
        }

        commentExecutorService.awaitTermination(10, TimeUnit.SECONDS);
        postExecutorService.awaitTermination(10, TimeUnit.SECONDS);
        commentExecutorService.shutdown();
        postExecutorService.shutdown();
        System.out.println(postService.getPosts());
    }
}

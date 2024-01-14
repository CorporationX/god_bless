package faang.school.godbless.multithreading.volotileImmutable.addComments;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommentsApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PostService postService = new PostService();
        ExecutorService executorService = Executors.newCachedThreadPool();


        for (int i = 0; i < 3; i++) {
            final int postId = i;
            executorService.submit(() -> {
                Post post = new Post("Post-" + postId, "Text-Post-" + postId, "Author-" + postId);
                postService.addPost(post);
                System.out.println("Added post - " + postId);
            });

        }

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int commentId = i;
            executorService.submit(() -> {
                int postId = random.nextInt(3);
                Comment comment = new Comment("Comment" + postId, LocalDateTime.now(), "User-" + commentId);
                postService.addComment(comment, postId);
                System.out.println("Comment added to post " + postId + ": " + comment.getTextComment());
            });
        }

        executorService.shutdown();
    }
}

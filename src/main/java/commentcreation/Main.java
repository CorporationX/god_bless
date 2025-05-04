package commentcreation;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        PostService service = new PostService();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int userId = i;
            executorService.submit(() -> {
                Post post = new Post();
                post.setTitle("title of post from #" + userId);
                post.setContent("Content #" + userId);
                post.setAuthor("User #" + userId);
                service.addPost(post);
                System.out.printf("post added from user #%s%n", post.getAuthor());
            });
        }

        for (int i = 0; i < 20; i++) {
            int userId = i;
            executorService.submit(() -> {
                int postId = random.nextInt(10) + 1;
                Comment comment = new Comment("comment from user " + userId,
                        "User_" + userId, LocalDateTime.now());
                service.addComment(postId, comment);
                System.out.printf("comment added to post #%s%n", postId);
            });
        }

        for (int i = 0; i < 5; i++) {
            int userId = i;
            executorService.submit(() -> {
                int postId = random.nextInt(10) + 1;
                service.deletePost(postId, "User_" + userId);
                System.out.printf("post #%s deleted%n", postId);
            });
        }

        for (int i = 0; i < 10; i++) {
            int userId = i;
            executorService.submit(() -> {
                int postId = random.nextInt(10) + 1;
                LocalDateTime timestampToDelete = LocalDateTime.now().minusMinutes(random.nextInt(60));
                service.deleteComment(postId, "User_" + userId, timestampToDelete);
                System.out.printf("comment #%s deleted%n", timestampToDelete);
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\n----- EndsWith posts -----");

        service.getAllPosts().forEach(post -> {

            System.out.printf("%d, %s, %s, %s%n", post.getId(), post.getTitle(),
                    post.getContent(), post.getAuthor());

            service.getCommentsForPost(post.getId()).forEach(comment ->
                    System.out.printf("%s, %s, %s%n", comment.getAuthor(),
                            comment.getText(), comment.getTimestamp()));
        });
    }
}

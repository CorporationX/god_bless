package school.faang.task_62589;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();

        Post post = new Post(1, "First Post",
                "Hello World!", "Alice");
        postService.addPost(post);

        int numOfComments = 10;
        CompletableFuture<?>[] tasks = new CompletableFuture<?>[numOfComments];

        for (int i = 0; i < numOfComments; i++) {
            int finalI = i;
            tasks[i] = CompletableFuture.runAsync(() -> {
                Comment comment = new Comment("Comment "
                        + finalI, "User" + finalI, LocalDateTime.now());
                postService.addComment(1, comment);
            }).exceptionally(e -> {
                System.out.printf("Ошибка обнаружена: %s%n" +
                                "Ошибка в комментарии: %d%n",
                        e.getMessage(), finalI);
                return null;
            });
        }

        CompletableFuture.allOf(tasks).join();

        System.out.println("Post Comments:");
        post.getComments().forEach(((localDateTime, comment) ->
                System.out.println(comment.getAuthor() + ": " + comment.getText())));

        if (!post.getComments().isEmpty()) {
            Comment commentToDelete = post.getComments().values().iterator().next();
            postService.deleteComment(1, commentToDelete.getTimestamp(),
                    commentToDelete.getAuthor());
            System.out.println("Deleted comment: " + commentToDelete.getText());
        }

        postService.deletePost(1, "Alice");
        System.out.println("Deleted Post 1");
    }
}

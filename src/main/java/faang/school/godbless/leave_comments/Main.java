package faang.school.godbless.leave_comments;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS);

        List<Comment> commentsForPost1 = List.of(
                new Comment("Author1", "Text1", LocalDateTime.now()),
                new Comment("Author2", "Text2", LocalDateTime.now()),
                new Comment("Author3", "Text3", LocalDateTime.now()),
                new Comment("Author4", "Text4", LocalDateTime.now()),
                new Comment("Author5", "Text5", LocalDateTime.now()),
                new Comment("Author6", "Text6", LocalDateTime.now())
        );

        List<Comment> commentsForPost2 = List.of(
                new Comment("Author7", "Text7", LocalDateTime.now()),
                new Comment("Author8", "Text8", LocalDateTime.now()),
                new Comment("Author9", "Text9", LocalDateTime.now()),
                new Comment("Author10", "Text10", LocalDateTime.now()),
                new Comment("Author11", "Text11", LocalDateTime.now()),
                new Comment("Author12", "Text12", LocalDateTime.now())
        );

        Runnable addPost1 = () -> postService.addPost(new Post(1, "Author post 1", "Some title", "Some text"));
        Runnable addPost2 = () -> postService.addPost(new Post(2, "Author post 2", "Another title", "Another text"));

        executorService.execute(addPost1);
        executorService.execute(addPost2);
        executorService.execute(() -> commentsForPost1.forEach(comment -> postService.addComment(comment, () -> 1)));
        executorService.execute(() -> commentsForPost2.forEach(comment -> postService.addComment(comment, () -> 2)));
        executorService.execute(() -> postService.deleteComment(() -> 1, new Comment("Author1", "Text1", LocalDateTime.now())));
        executorService.execute(() -> postService.deletePost(() -> 2, "Author post 2"));

        executorService.shutdown();
        executorService.awaitTermination(15, TimeUnit.SECONDS);
        System.out.println(postService.getComments(() -> 1));
        System.out.println(postService.getPosts());
    }
}

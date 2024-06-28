package faang.school.godbless.leave_comments;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService();

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

        Thread threadAddPost1 = new Thread(addPost1);
        Thread threadAddPost2 = new Thread(addPost2);

        Thread threadAddCommentsPost1 = new Thread(() -> {
            try {
                threadAddPost1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (Comment comment : commentsForPost1) {
                postService.addComment(comment, 1);
            }
        });

        Thread threadAddCommentsPost2 = new Thread(() -> {
            try {
                threadAddPost2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (Comment comment : commentsForPost2) {
                postService.addComment(comment, 2);
            }
        });

        threadAddPost1.start();
        threadAddPost2.start();
        threadAddCommentsPost1.start();
        threadAddCommentsPost2.start();

        threadAddCommentsPost1.join();
        threadAddCommentsPost2.join();

        System.out.println(postService.getPosts());
    }
}

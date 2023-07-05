package faang.school.godbless.LeaveAComment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService(new ArrayList<>());
        Comment comment1 = new Comment(1, "This is a test comment", LocalDateTime.now(), "John Doe");
        Comment comment2 = new Comment(2, "Another test comment", LocalDateTime.now(), "Jane Smith");
        Comment comment3 = new Comment(3, "A third test comment", LocalDateTime.now(), "Bob Johnson");
        Comment comment4 = new Comment(4, "Fourth test comment", LocalDateTime.now(), "Alice Lee");
        Comment comment5 = new Comment(5, "Fifth test comment", LocalDateTime.now(), "Tom Wilson");

        Post post1 = new Post(1, "title1", "te", "author", new ArrayList<>());
        Post post2 = new Post(2, "title2", "ex", "author", new ArrayList<>());
        Post post3 = new Post(3, "title3", "te", "author", new ArrayList<>());
        Post post4 = new Post(4, "title4", "ex", "author", new ArrayList<>());
        Post post5 = new Post(5, "title5", "te", "author", new ArrayList<>());

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(() -> {
            postService.addPost(post1);
            postService.addComment(1, comment1);
        });
        executorService.execute(() -> {
            postService.addPost(post2);
            postService.addComment(2, comment2);
        });
        executorService.execute(() -> {
            postService.addPost(post3);
            postService.addComment(3, comment3);
        });
        executorService.execute(() -> {
            postService.addPost(post4);
            postService.addComment(4, comment4);
        });
        executorService.execute(() -> {
            postService.addPost(post5);
            postService.addComment(5, comment5);
        });

        executorService.execute(() -> {
            postService.deletePost(2);
            System.out.println(postService.findPostById(1));
            System.out.println(postService.findCommentById(2));
        });

        executorService.execute(() -> {
            System.out.println(postService.findPostById(3));
            postService.deleteComment(1);
            System.out.println(postService.findCommentById(4));
        });

        executorService.shutdown();
    }
}

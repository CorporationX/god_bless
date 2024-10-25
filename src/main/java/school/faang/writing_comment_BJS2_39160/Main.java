package school.faang.writing_comment_BJS2_39160;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int AWAITING_TIME = 3;

    public static void main(String[] args) {

        Comment comment1 = new Comment("This is very insightful, thanks!", "Alice", LocalDateTime.now().minusDays(1));
        Comment comment2 = new Comment("I enjoyed reading this.", "Bob", LocalDateTime.now().minusHours(5));
        Comment comment3 = new Comment("I think this is a bit confusing.", "Charlie", LocalDateTime.now().minusMinutes(30));
        Comment comment4 = new Comment("Can you provide more examples?", "David", LocalDateTime.now().minusDays(2));
        Comment comment5 = new Comment("Good work, looking forward to more posts.", "Eve", LocalDateTime.now().minusHours(1));

        Post post1 = new Post(1, "Understanding Java Streams",
                "In this post, we explore the Stream API in Java...",
                "John Doe", new ArrayList<>());

        Post post2 = new Post(2, "Effective Java Concurrency",
                "Concurrency is one of the most complex topics in Java. Here's how you can master it...",
                "Robert Martin", new ArrayList<>());

        List<Comment> comments1 = new ArrayList<>(List.of(comment1, comment2, comment3));
        List<Comment> comments2 = new ArrayList<>(List.of(comment4, comment5));
        List<Post> posts = new ArrayList<>(List.of(post1, post2));

        ExecutorService service = Executors.newCachedThreadPool();
        PostService postService = new PostService();

        posts.forEach(post -> service.submit(() -> postService.addPost(post)));

        comments1.forEach(comment -> service.submit(() -> postService.addComment(1, comment)));
        comments2.forEach(comment -> service.submit(() -> postService.addComment(2, comment)));

        service.submit(() -> postService.showPost(post2));
        service.submit(() -> postService.deletePost(post1, "John Doe"));

        service.submit(() -> postService.showComment(post2, comment4));
        service.submit(() -> postService.deleteComment(post2, comment5, "Eve"));

        service.shutdown();
        try {
            if (service.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES))
                System.out.println(postService.getPosts());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

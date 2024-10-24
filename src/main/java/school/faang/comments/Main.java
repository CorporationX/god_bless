package school.faang.comments;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService service = Executors.newFixedThreadPool(5);

        Comment comment1 = new Comment("Great post!", "User1", LocalDateTime.now());
        Comment comment2 = new Comment("Very informative.", "User2", LocalDateTime.now().minusMinutes(5));
        Comment comment3 = new Comment("I learned a lot.", "User3", LocalDateTime.now().minusHours(1));
        Comment comment4 = new Comment("Thanks for sharing!", "User4", LocalDateTime.now().minusDays(1));
        Comment comment5 = new Comment("Interesting perspective.", "User5", LocalDateTime.now().minusHours(2));

        Post post1 = new Post(1, "Java Basics", "Introduction to Java programming.", "Alice");
        Post post2 = new Post(2, "Spring Framework", "Getting started with Spring.", "Bob");
        Post post3 = new Post(3, "Data Structures", "Understanding data structures in Java.", "Charlie");
        Post post4 = new Post(4, "Multithreading in Java", "Exploring multithreading concepts.", "David");
        Post post5 = new Post(5, "Java Streams", "Working with streams in Java.", "Eva");

        service.submit(() -> postService.addPost(post1));
        service.submit(() -> postService.addPost(post2));
        service.submit(() -> postService.addPost(post3));
        service.submit(() -> postService.addPost(post4));
        service.submit(() -> postService.addPost(post5));

        service.submit(() -> postService.addComment(1, comment1));
        service.submit(() -> postService.addComment(2, comment2));
        service.submit(() -> postService.addComment(3, comment3));
        service.submit(() -> postService.addComment(4, comment4));
        service.submit(() -> postService.addComment(5, comment5));

        System.out.println("-----------------------");

        postService.showAllPosts();

        postService.removePostsByAuthor("Charlie");
        postService.removeCommentByAuthor("User4");

        System.out.println("-----------------------");

        postService.showAllPosts();

        service.shutdown();

    }
}

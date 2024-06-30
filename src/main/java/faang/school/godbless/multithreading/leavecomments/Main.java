package faang.school.godbless.multithreading.leavecomments;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int threadsNumber = Runtime.getRuntime().availableProcessors();
        ExecutorService threadPool = Executors.newFixedThreadPool(threadsNumber);

        PostService postService = new PostService(new CopyOnWriteArrayList<>());

        Post firstPost = new Post("My First Post",
                "This is the content of my first firstPost.",
                "Author1",
                new CopyOnWriteArrayList<>());
        Post secondPost = new Post(
                "My Second Post",
                "This is the content of my second firstPost.",
                "Author2",
                new CopyOnWriteArrayList<>()
        );

        postService.addPost(firstPost);
        postService.addPost(secondPost);

        List<Comment> commentsList = List.of(
                new Comment("Commenter1", LocalDateTime.now(), "This is comment 1."),
                new Comment("Commenter2", LocalDateTime.now(), "This is comment 2."),
                new Comment("Commenter3", LocalDateTime.now(), "This is comment 3."),
                new Comment("Commenter4", LocalDateTime.now(), "This is comment 4."),
                new Comment("Commenter5", LocalDateTime.now(), "This is comment 5."),
                new Comment("Commenter6", LocalDateTime.now(), "This is comment 6."),
                new Comment("Commenter7", LocalDateTime.now(), "This is comment 7."),
                new Comment("Commenter8", LocalDateTime.now(), "This is comment 8."),
                new Comment("Commenter9", LocalDateTime.now(), "This is comment 9."),
                new Comment("Commenter10", LocalDateTime.now(), "This is comment 10."),
                new Comment("Commenter11", LocalDateTime.now(), "This is comment 11."),
                new Comment("Commenter12", LocalDateTime.now(), "This is comment 12."),
                new Comment("Commenter13", LocalDateTime.now(), "This is comment 13."),
                new Comment("Commenter14", LocalDateTime.now(), "This is comment 14."),
                new Comment("Commenter15", LocalDateTime.now(), "This is comment 15."),
                new Comment("Commenter16", LocalDateTime.now(), "This is comment 16."),
                new Comment("Commenter17", LocalDateTime.now(), "This is comment 17."),
                new Comment("Commenter18", LocalDateTime.now(), "This is comment 18."),
                new Comment("Commenter19", LocalDateTime.now(), "This is comment 19."),
                new Comment("Commenter20", LocalDateTime.now(), "This is comment 20.")
        );
        commentsList.forEach(com ->
                threadPool.submit(() ->
                        postService.addComment(ThreadLocalRandom.current().nextInt(0, 2), com)));

        threadPool.shutdown();
        threadPool.awaitTermination(30, TimeUnit.SECONDS);

        System.out.println(firstPost.comments());
        System.out.println(secondPost.comments());
    }
}

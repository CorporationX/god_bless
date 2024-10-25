package ru.kraiush.BJS2_39206;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Post post1 = new Post(1, "Introduction to Java", "Learn the basics of Java programming.", "Alice", new ArrayList<>());
        Post post2 = new Post(2, "Java Collections", "Understanding collections in Java.", "Bob", new ArrayList<>());
        Post post3 = new Post(3, "Spring Boot Overview", "An overview of Spring Boot features.", "Charlie", new ArrayList<>());
        Post post4 = new Post(4, "Building REST APIs", "Create RESTful services using Spring.", "David", new ArrayList<>());
        Post post5 = new Post(5, "Microservices Architecture", "Understanding microservices design.", "Eva", new ArrayList<>());
        Post post6 = new Post(6, "Java Streams API", "Explore Java's Streams API for data.", "Frank", new ArrayList<>());

        Comment comment1 = new Comment("Great introduction!", "George", LocalDateTime.now());
        Comment comment2 = new Comment("Very informative.", "Hannah", LocalDateTime.now());
        Comment comment3 = new Comment("Loved the examples!", "Ian", LocalDateTime.now());
        Comment comment4 = new Comment("Could use more details.", "Jenna", LocalDateTime.now());
        Comment comment5 = new Comment("Nice explanation.", "Kyle", LocalDateTime.now());
        Comment comment6 = new Comment("Spring Boot is amazing!", "Laura", LocalDateTime.now());
        Comment comment7 = new Comment("Microservices are the future.", "Mike", LocalDateTime.now());
        Comment comment8 = new Comment("Excellent post on collections!", "Nina", LocalDateTime.now());
        Comment comment9 = new Comment("I found this very helpful.", "Oscar", LocalDateTime.now());
        Comment comment10 = new Comment("Looking forward to more articles.", "Pam", LocalDateTime.now());

        PostService postService = new PostService();
        postService.addPost(post1);
        postService.addPost(post2);
        postService.addPost(post3);

        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(() -> {
            postService.addPost(post4);
            postService.addComment(1, comment1);
        });
        executor.submit(() -> {
            postService.addPost(post5);
            postService.addComment(2, comment2);
        });
        executor.submit(() -> {
            postService.addPost(post6);
            postService.addComment(3, comment3);
            postService.addComment(3, comment10);

        });
        executor.submit(() -> {
            postService.addComment(4, comment4);
            postService.addComment(5, comment5);
            postService.addComment(6, comment6);
            postService.removePost(6);
        });
        executor.submit(() -> {
            postService.addComment(4, comment7);
            postService.addComment(5, comment8);
            postService.addComment(6, comment9);
        });

        executor.shutdown();

        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                postService.viewPostsWithComments();
                postService.viewPostWithComments(1);
                postService.viewPostWithComments(3);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

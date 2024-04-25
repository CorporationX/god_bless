package faang.school.godbless.concurrency.comment;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService usersPool = Executors.newCachedThreadPool();

        log.info("Number of posts in system at this point: "  +postService.getPosts().size());
        
        var newPostByDenis1 = CompletableFuture.runAsync(() -> postService.addPost("How was my day", "Not bad.", "Denis"), usersPool);
        var newPostByDenis2 = CompletableFuture.runAsync(() -> postService.addPost("How was my day", "It was okay.", "Denis"), usersPool);
        var newPostByOleg1 = CompletableFuture.runAsync(() -> postService.addPost("I learned a new phrase", "Hello world", "Oleg"), usersPool);
        var newPostByOleg2 = CompletableFuture.runAsync(() -> postService.addPost("Story about my participation in Hackathon", "We won it!", "Oleg"), usersPool);
        var newPostByVasya = CompletableFuture.runAsync(() -> postService.addPost("How was my day", "It was really good!", "Vasya"), usersPool);
        
        CompletableFuture.allOf(newPostByDenis1, newPostByDenis2, newPostByOleg1, newPostByOleg2, newPostByVasya).join();


        log.info("Posts in system at this point:");
        postService.getPosts().forEach(post -> log.info(post.toString()));

        var newCommentByDenis1 = CompletableFuture.runAsync(() -> postService.addComment(0, "Cool!", "Denis"), usersPool);
        var newCommentByVasya1 = CompletableFuture.runAsync(() -> postService.addComment(1, "F", "Vasya"), usersPool);
        var newCommentByOleg = CompletableFuture.runAsync(() -> postService.addComment(1, "That's my boy!", "Oleg"), usersPool);
        var newCommentByVasya2 = CompletableFuture.runAsync(() -> postService.addComment(2, "F", "Vasya"), usersPool);
        var newCommentByDenis2 = CompletableFuture.runAsync(() -> postService.addComment(0, "That's really good content!", "Denis"), usersPool);
        var newCommentByVasya3 = CompletableFuture.runAsync(() -> postService.addComment(1, "I paid respect", "Vasya"), usersPool);

        CompletableFuture.allOf(newCommentByDenis1, newCommentByVasya1, newCommentByOleg, newCommentByVasya2, newCommentByDenis2, newCommentByVasya3).join();


        log.info("Posts in system at this point:");
        postService.getPosts().forEach(post -> log.info(post.toString()));

        var postDeleting1 = CompletableFuture.runAsync(() -> {
            try {
                postService.removePostById(0, "Denis");
            } catch (IllegalAccessException e) {
                log.error("Denis tried to remove foreign post");
            }
        }, usersPool);

        var postDeleting2 = CompletableFuture.runAsync(() -> {
            try {
                postService.removePostById(2, "Oleg");
            } catch (IllegalAccessException e) {
                log.error("Oleg tried to remove foreign post");
            }
        }, usersPool);

        var commentDeleting = CompletableFuture.runAsync(() -> {
            try {
                postService.removeCommentById(0, 0, "Denis");
            } catch (IllegalAccessException e) {
                log.error("Denis tried to remove foreign post");
            }
        }, usersPool);

        CompletableFuture.allOf(postDeleting1, postDeleting2, commentDeleting).join();


        log.info("Posts in system at this point:");
        postService.getPosts().forEach(post -> log.info(post.toString()));

        usersPool.shutdown();
    }
}

package bjs262572;


import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(2);
    private static final int THREAD_SLEEP_IN_MS = 1000;
    private static final int AWAIT_TERMINATION_IN_MS = 3000;

    public static void main(String[] args) {
        Post post1 = new Post(1, "Title1", "Content1", "PostAuthor1");
        List<Comment> comments1 = new ArrayList<>(List.of(
                new Comment("Text1", "CommentAuthor1",
                        LocalDateTime.of(LocalDate.of(2025, 2, 26),
                                LocalTime.of(22, 34))),
                new Comment("Text2", "CommentAuthor2",
                        LocalDateTime.of(LocalDate.of(2025, 1, 5),
                                LocalTime.of(21, 29))),
                new Comment("Text3", "CommentAuthor3",
                        LocalDateTime.of(LocalDate.of(2025, 1, 10),
                                LocalTime.of(19, 25)))
        ));
        post1.getComments().addAll(comments1);

        Post post2 = new Post(2, "Title2", "Content2", "PostAuthor2");
        List<Comment> comments2 = new ArrayList<>(List.of(
                new Comment("Text4", "CommentAuthor4",
                        LocalDateTime.of(LocalDate.of(2025, 2, 26),
                                LocalTime.of(10, 51))),
                new Comment("Text5", "CommentAuthor5",
                        LocalDateTime.of(LocalDate.of(2025, 2, 26),
                                LocalTime.of(10, 51)))
        ));
        post2.getComments().addAll(comments2);

        Post post3 = new Post(3, "Title3", "Content3", "PostAuthor3");
        List<Comment> comments3 = new ArrayList<>(List.of(
                new Comment("Text6", "CommentAuthor6",
                        LocalDateTime.of(LocalDate.of(2024, 2, 26),
                                LocalTime.of(10, 51))),
                new Comment("Text7", "CommentAuthor7",
                        LocalDateTime.of(LocalDate.of(2024, 2, 26),
                                LocalTime.of(10, 51)))
        ));
        post3.getComments().addAll(comments3);

        PostService postService = new PostService();
        addPost(postService, post1);
        addPost(postService, post2);
        addPost(postService, post3);

        Comment firstAdditionalComment = new Comment("Text4", "CommentAuthor4",
                LocalDateTime.of(LocalDate.of(2024, 2, 26),
                        LocalTime.of(10, 51)));
        addComment(postService, 1, firstAdditionalComment);

        Comment secondAdditionalComment = new Comment("Text5", "CommentAuthor5",
                LocalDateTime.of(LocalDate.of(2021, 2, 26),
                        LocalTime.of(10, 51)));
        addComment(postService, 2, secondAdditionalComment);
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_IN_MS, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    private static void addPost(PostService postService, Post post) {
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(THREAD_SLEEP_IN_MS);
                postService.addPost(post);
            } catch (InterruptedException e) {
                log.error("Thread {} interrupted", Thread.currentThread().getId(),
                        new PostException("Interrupted exception"));
                Thread.currentThread().interrupt();
            }
        }, executorService);
    }

    private static void addComment(PostService postService, int postId, Comment comment) {
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(THREAD_SLEEP_IN_MS);
                postService.addComment(postId, comment);
            } catch (InterruptedException e) {
                log.error("Thread {} interrupted", Thread.currentThread().getId(),
                        new PostException("Interrupted exception"));
                Thread.currentThread().interrupt();
            }
        }, executorService);
    }
}

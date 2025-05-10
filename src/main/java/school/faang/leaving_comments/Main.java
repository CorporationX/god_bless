package school.faang.leaving_comments;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);

        try {
            CompletableFuture<Void> addPosts = CompletableFuture.allOf(
                    CompletableFuture.runAsync(() ->
                            postService.addPost(new Post("Post 1", "Content 1", "User 1")), pool),
                    CompletableFuture.runAsync(() ->
                            postService.addPost(new Post("Post 2", "Content 2", "User 2")), pool),
                    CompletableFuture.runAsync(() ->
                            postService.addPost(new Post("Post 3", "Content 3", "User 3")), pool)
            );

            addPosts.join();
            log.info("All posts added. Current posts:");
            postService.getAllPosts().forEach(Main::printPost);

            CompletableFuture<Void> addComments = addPosts.thenRunAsync(() ->
                    CompletableFuture.allOf(
                            CompletableFuture.runAsync(() ->
                                    postService.addComment(1, new Comment("Great post!", "User A")), pool),
                            CompletableFuture.runAsync(() ->
                                    postService.addComment(1, new Comment("Thanks for sharing.", "User B")), pool),
                            CompletableFuture.runAsync(() ->
                                    postService.addComment(2, new Comment("Very informative content!", "User C")), pool)
                    ).join(), pool);

            addComments.join();
            log.info("Comments added to posts. Current comments:");
            postService.getAllPosts().forEach(post -> {
                Main.printPost(post);
                post.getComments().forEach(comment ->
                        log.info("  Comment ID: {}, Text: {}, Author: {}",
                                comment.getId(), comment.getText(), comment.getAuthor()));
            });

            CompletableFuture<Void> getComments = addComments.thenRunAsync(() -> {
                log.info("=== Testing getCommentsByPostId ===");
                try {
                    log.info("Comments for Post ID 1:");
                    postService.getCommentsByPostId(1).forEach(Main::printComment);

                    log.info("Comments for Post ID 2:");
                    postService.getCommentsByPostId(2).forEach(Main::printComment);
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            }, pool);

            getComments.join();

            CompletableFuture<Void> deleteComments = getComments.thenRunAsync(() -> {
                log.info("\n=== Testing deleteComment ===");
                postService.deleteComment(1, 0, "User A");
                log.info("After deleting a comment from Post ID 1:");
                postService.getAllPosts().forEach(Main::printPost);
            }, pool);

            deleteComments.join();

            CompletableFuture<Void> deletePosts = deleteComments.thenRunAsync(() -> {
                log.info("\n=== Testing deletePost ===");
                postService.deletePost(2, "User 2");
                log.info("After deleting Post ID 2:");
                postService.getAllPosts().forEach(Main::printPost);
            }, pool);

            deletePosts.join();

            CompletableFuture<Void> getAll = deletePosts.thenRunAsync(() -> {
                log.info("\n=== Testing getAllPosts ===");
                log.info("Remaining posts:");
                postService.getAllPosts().forEach(post -> log.info("Post ID: {}, Title: {}, Author: {}",
                        post.getId(), post.getTitle(), post.getAuthor()));
            }, pool);

            getAll.join();

        } finally {
            pool.shutdown();
        }
    }

    private static void printComment(Comment comment) {
        log.info("Comment ID: {}, Text: {}, Author: {}",
                comment.getId(), comment.getText(), comment.getAuthor());
    }

    private static void printPost(Post post) {
        log.info("Post ID: {}, Title: {}", post.getId(), post.getTitle());
    }
}
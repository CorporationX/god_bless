package faang.school.godbless.bjs2_25421;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.MINUTES;

@Slf4j
public class Main {
    private static final int COMMENTS_AMOUNTS = 2;
    private static final PostService postService = new PostService();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        List<Post> posts = initPosts();
        posts.forEach(post -> executorService.execute(
                () -> postService.addPost(post))
        );

        posts.forEach(post -> {
            List<Comment> comments = initComments(post.getId());
            comments.forEach(comment -> executorService.execute(
                    () -> postService.addComment(post.getId(), comment))
            );
        });

        executorService.submit(() -> postService.deletePost(2, "author2"));
        executorService.submit(() -> postService.deletePost(2, "author1"));

        executorService.submit(() -> postService.addComment(2, new Comment(23, "text 3", LocalDateTime.now(), "author 3")));
        executorService.submit(() -> postService.addComment(1, new Comment(13, "text 3", LocalDateTime.now(), "author 3")));

        executorService.submit(() -> postService.deleteComment(2, 21, "author 2"));
        executorService.submit(() -> postService.deleteComment(1, 11, "author 2"));
        executorService.submit(() -> postService.deleteComment(1, 11, "author 1"));

        shutdownAndAwait(executorService);

        printPosts();
        posts.forEach(post -> {
            printCommentsByPost(post.getId());
        });
    }

    private static void shutdownAndAwait(ExecutorService executorService) {
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
    }

    private static void printPosts() {
        List<Post> posts = postService.readAllPosts();
        log.info("All Posts:");
        posts.forEach(p -> log.info("   {} {}", p.getId(), p.getText()));
    }

    private static void printCommentsByPost(int postId) {
        List<Comment> comments = postService.readAllComments(postId);
        if (!comments.isEmpty()) {
            log.info("Comments for Post {}:", postId);
            comments.forEach(c -> log.info("    {}", c.getText()));
        }
    }

    private static List<Comment> initComments(int postId) {
        List<Comment> comments = new ArrayList<>();
        for (int i = 1; i <= COMMENTS_AMOUNTS; i++) {
            comments.add(Comment.builder()
                    .id(postId * 10 + i)
                    .text("text " + i)
                    .dateTime(LocalDateTime.now())
                    .author("author " + i)
                    .build());
        }
        return comments;
    }

    private static List<Post> initPosts() {
        return List.of(
                new Post(1, "header1", "text1", "author1"),
                new Post(2, "header2", "text2", "author2"),
                new Post(3, "header3", "text3", "author3"));
    }
}

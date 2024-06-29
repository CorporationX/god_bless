package faang.school.godbless.concur1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 3;
    private static final long WAITING_TIME = 1000L;

    public static void main(String[] args) throws InterruptedException {
        PostService postService = new PostService();
        List<Post> posts = getPosts();
        List<Comment> comments = getComments();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        posts.forEach(post -> executor.execute(() -> postService.addPost(post)));
        Thread.sleep(WAITING_TIME);
        postService.getPosts().forEach(post -> executor.execute(() -> comments
                .forEach(comment -> postService.addComment(post.id(), comment))));
        executor.shutdown();
        if (executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS)) {
            postService.viewAllPosts();
        }
    }

    private static List<Comment> getComments() {
        return List.of(
                new Comment(0, "comment0", LocalDateTime.now(), "author1"),
                new Comment(1, "comment1", LocalDateTime.now(), "author1"),
                new Comment(2, "comment2", LocalDateTime.now(), "author2"),
                new Comment(NUM_THREADS, "comment3", LocalDateTime.now(), "author3"));
    }

    private static List<Post> getPosts() {
        return List.of(
                new Post(0, "title0", "text0", "author1"),
                new Post(1, "title1", "text1", "author1"),
                new Post(2, "title2", "text2", "author2"),
                new Post(NUM_THREADS, "title3", "text3", "author3"),
                new Post(4, "title4", "text4", "author2"));
    }
}

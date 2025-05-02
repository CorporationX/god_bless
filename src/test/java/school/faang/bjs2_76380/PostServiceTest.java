package school.faang.bjs2_76380;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PostServiceTest {
    private PostService postService;

    @BeforeEach
    void setUp() {
        postService = new PostService();
    }

    @Test
    void shouldAddPostsConcurrently() throws InterruptedException {
        int threadCount = 10;
        ExecutorService pool = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);

        IntStream.range(0, threadCount).forEach(i -> pool.submit(() -> {
            try {
                User user = new User("author " + i);
                List<Comment> comments = new ArrayList<>(List.of(
                        new Comment("comment " + i, user, LocalDateTime.now())));
                postService.addPost(new Post(i, "title " + i, "content " + i, user, comments));
            } finally {
                latch.countDown();
            }
        }));

        latch.await();
        poolShutdown(pool);

        List<Post> allPosts = postService.getAllPosts();
        assertEquals(threadCount, allPosts.size());
    }

    void poolShutdown(ExecutorService pool) {
        pool.shutdown();
        try {
            boolean isClose = pool.awaitTermination(60, SECONDS);
            if (!isClose) {
                pool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            pool.shutdownNow();
        }
    }

    @Test
    void shouldReturnCorrectComments() {
        User user = new User("author");
        Comment comment = new Comment("comment", user, LocalDateTime.now());
        Post post = new Post(1, "title", "content", user, new ArrayList<>(List.of(comment)));

        postService.addPost(post);
        List<Comment> comments = postService.getComments(1);

        assertEquals(1, comments.size());
        assertEquals("comment", comments.get(0).text());
    }

    @Test
    void shouldDeletePostByAuthor() {
        User user = new User("author");
        Post post = new Post(2, "title", "content", user, new ArrayList<>());

        postService.addPost(post);
        postService.deletePost(2, user);

        assertThrows(PostNotFoundException.class, () -> postService.getComments(2));
    }

    @Test
    void shouldDeleteCommentByAuthor() {
        User user = new User("author");
        Comment comment = new Comment("comment", user, LocalDateTime.now());
        Post post = new Post(3, "title", "content", user, new ArrayList<>(List.of(comment)));

        postService.addPost(post);
        postService.deleteComment(3, comment, user);

        List<Comment> comments = postService.getComments(3);
        assertTrue(comments.isEmpty());
    }

    @Test
    void shouldThrowWhenDeletingOthersPost() {
        User owner = new User("owner");
        User intruder = new User("intruder");
        Post post = new Post(4, "title", "content", owner, new ArrayList<>());

        postService.addPost(post);
        assertThrows(UnauthorizedModificationException.class,
                () -> postService.deletePost(4, intruder)
        );
    }

    @Test
    void shouldThrowWhenDeletingOthersComment() {
        User owner = new User("owner");
        User intruder = new User("intruder");
        Comment comment = new Comment("comment", owner, LocalDateTime.now());
        Post post = new Post(5, "title", "content", owner, new ArrayList<>(List.of(comment)));

        postService.addPost(post);
        assertThrows(UnauthorizedModificationException.class,
                () -> postService.deleteComment(5, comment, intruder)
        );
    }
}


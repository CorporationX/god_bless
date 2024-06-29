package faang.school.godbless.LeaveComment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final Random RANDOM = new Random();
    private static final int COUNT_THREAD = 100;
    private static final ExecutorService ex = Executors.newFixedThreadPool(COUNT_THREAD);

    public static void main(String[] args) {
        PostService postService = new PostService();
        List<Comment> comments = createComment(50);
        List<Post> posts = createPost(5);
        posts.forEach(post -> ex.submit(() -> postService.addPost(post)));
        comments.forEach(comment -> {
            ex.submit(() -> {
                try {
                    postService.addComment(RANDOM.nextInt(1, postService.getPosts().size() + 1), comment);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });
        ex.shutdown();
        postService.getInfo();

    }

    private static List<Comment> createComment(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(item -> new Comment("text" + item, LocalDateTime.now(), "author" + item))
                .toList();
    }

    private static List<Post> createPost(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> new Post(i, "title" + i, "author " + i, new ArrayList<>()))
                .toList();
    }
}

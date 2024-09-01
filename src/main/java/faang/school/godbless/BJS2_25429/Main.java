package faang.school.godbless.BJS2_25429;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        PostService postService = new PostService();
        postService.addPost(1, new Post("Medium", "post 1"));
        postService.addPost(2, new Post("Habr", "post 2"));

        List<Comment> comments = getComments();
        ExecutorService executor = Executors.newFixedThreadPool(comments.size());

        comments.forEach(comment -> executor.execute(
                () -> postService.addComment(random.nextInt(1, 3), comment)
        ));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        System.out.println();
        postService.dump();
    }

    private static List<Comment> getComments() {
        return IntStream.rangeClosed(1, 100)
                .mapToObj(i -> new Comment("Автор: " + (i), "#" + (i), LocalDateTime.now()))
                .toList();
    }
}

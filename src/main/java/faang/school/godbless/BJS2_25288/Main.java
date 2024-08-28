package faang.school.godbless.BJS2_25288;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        var postService = new PostService();

        var executorService = Executors.newFixedThreadPool(3);

        executorService.submit(() -> {
            var random = new Random();
            int i = 0;

            while (true) {
                i++;

                if (i > 5) {
                    Thread.sleep(10000);
                }

                var post = new Post("Title " + (i + 1), "Content " + (i + 1),
                        "Author " + random.nextInt(1, 15));
                postService.addPost(post);

            }
        });

        executorService.submit(() -> {
            var random = new Random();

            int i = 0;
            while (true) {
                i++;
                Thread.sleep(2000);

                var posts = postService.getPosts();
                for (int j = 0; j < random.nextInt(30); j++) {
                    postService.addComment(random.nextInt(posts.size()), new Comment("Comment " + j,
                            "Author " + random.nextInt(15)));
                }
            }
        });


        executorService.submit(() -> {
            while (true) {
                Thread.sleep(3000);
                postService.viewPost(new Random().nextInt(postService.getPosts().size()));
            }
        });

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(40, TimeUnit.SECONDS)) {
                executorService.shutdownNow();// Для завершения программы через 40 сек.!
                var commentsLeft = postService.getPosts().stream()
                        .mapToInt(value -> value.getComments().size())
                        .sum();

                System.out.printf("\u001B[41mTotal posts: %d, total comments: %d \u001B[0m",
                        postService.getPosts().size(), commentsLeft);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
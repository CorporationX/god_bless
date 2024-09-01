package faang.school.godbless.BJS2_25288;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        var postService = new PostService();

        var executorService = Executors.newFixedThreadPool(4);

        executorService.submit(() -> {
            var random = new Random();
            int i = 0;

            while (true) {

                if (i > 10) {
                    try {
                        Thread.sleep(new Random().nextInt(10001));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }

                var post = new Post(i + 1, "Title " + (i + 1), "Content " + (i + 1),
                        "Author " + random.nextInt(1, 15));
                postService.addPost(post);

                i++;
            }
        });

        executorService.submit(() -> {
            var random = new Random();

            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }

                var Ids = postService.getPosts().stream()
                        .mapToInt(Post::getId)
                        .toArray();
                var randomId = new Random().nextInt(Ids.length);
//                Добавление к случайному посту по id рандомное количество коментариев
                for (int j = 0; j < random.nextInt(30); j++) {
                    postService.addComment(randomId, new Comment("New comment",
                            "Author " + random.nextInt(15)));
                }
            }
        });


        executorService.submit(() -> {
            while (true) {
                try {
                    Thread.sleep(4500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }

                var ids = postService.getPosts().parallelStream()
                        .mapToInt(Post::getId)
                        .toArray();

//                Читаем случайный пост по id
                var randomId = ids[new Random().nextInt(ids.length)];
                postService.viewPost(randomId);
            }
        });

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();// Для завершения программы через минуту.
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
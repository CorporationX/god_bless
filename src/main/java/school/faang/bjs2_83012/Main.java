package school.faang.bjs2_83012;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 4;
    private static final int USERS_COUNT = 10;
    private static final int TIMEOUT_IN_SEC = 20;

    public static void main(String[] args) {
        Random random = new Random();
        PostService postService = new PostService(new ArrayList<>());
        ExecutorService poolThreads = Executors.newFixedThreadPool(NUM_THREADS);

        List<User> users = IntStream.range(0, USERS_COUNT)
                .mapToObj(i -> new User(i, "User %d".formatted(i)))
                .toList();

        for (User user : users) {
            poolThreads.submit(
                    () -> {
                        long id = user.getId();
                        Post post = new Post(id, "Title %d".formatted(id), "Content", user, new ArrayList<>());
                        postService.addPost(post);

                        if (!postService.isEmptyPosts()) {
                            Comment comment = new Comment(
                                    "TExt " + id,
                                    users.get(random.nextInt(users.size())),
                                    LocalTime.now()
                            );
                            postService.addComment(random.nextInt(users.size()), comment);
                        }
                    });
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (User user : users) {
            poolThreads.submit(
                    () -> {
                        if (ThreadLocalRandom.current().nextBoolean()) {
                            postService.printPostAndComments(random.nextInt((int) user.getId()));
                        }

                        if (ThreadLocalRandom.current().nextBoolean()) {
                            List<Post> userPosts = postService.getPostsByAuthor(user.getId());

                            if (!userPosts.isEmpty()) {
                                Post postToRemove = userPosts.get(
                                        ThreadLocalRandom.current().nextInt(userPosts.size()));

                                postService.removePost(postToRemove.getId());
                                log.info("Пользователь {} удалил свой пост {}", user.getName(), postToRemove.getId());
                            }
                        }
                    }
            );
        }
        breakPoolThreads(poolThreads);

    }

    private static void breakPoolThreads(ExecutorService poolThreads) {
        poolThreads.shutdown();
        try {
            if (!poolThreads.awaitTermination(TIMEOUT_IN_SEC, TimeUnit.SECONDS)) {
                log.info("Досрочное завершение потоков");
                poolThreads.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Досрочное завершение потоков", e);
            poolThreads.shutdownNow();
        }
    }
}

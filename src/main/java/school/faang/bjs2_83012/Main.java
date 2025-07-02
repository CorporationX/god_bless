package school.faang.bjs2_83012;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 4;
    private static final int USERS_COUNT = 10;
    private static final int TIMEOUT_IN_SEC = 20;
    private static final Random random = new Random();

    public static void main(String[] args) {
        PostService postService = new PostService(new ArrayList<>());
        ExecutorService poolThreads = Executors.newFixedThreadPool(NUM_THREADS);

        List<User> users = generateUsers();

        submitPostCreationTask(poolThreads, users, postService);
        submitPostInteractionTask(poolThreads, users, postService);

        breakPoolThreads(poolThreads);
    }

    private static void submitPostCreationTask(
            ExecutorService executor,
            List<User> users,
            PostService postService
    ) {
        users.forEach(user ->
                executor.submit(() -> {
                    createAndAddPost(postService, user);
                    addRandomCommentToRandomPost(postService, users);
                })
        );
    }

    private static void submitPostInteractionTask(
            ExecutorService executor,
            List<User> users,
            PostService postService
    ) {
        users.forEach(user ->
                executor.submit(() -> {
                    printRandomPostComments(postService);
                    deleteRandomPost(postService, user);
                })
        );
    }

    private static List<User> generateUsers() {
        return IntStream.range(0, Main.USERS_COUNT)
                .mapToObj(i -> new User(i, "User %d".formatted(i)))
                .toList();
    }

    private static void addRandomCommentToRandomPost(PostService postService, List<User> users) {
        if (postService.isEmptyPosts()) {
            return;
        }

        User randomUser = getRandomUser(users);
        long randomPostId = getRandomPostId(users.size());
        Comment comment = new Comment(
                "TExt " + randomUser.getId(),
                randomUser,
                LocalDateTime.now()
        );
        postService.addComment(randomPostId, comment);
    }

    private static User getRandomUser(List<User> users) {
        return users.get(random.nextInt(users.size()));
    }

    private static long getRandomPostId(int usersCount) {
        return random.nextInt(usersCount);
    }

    private static void createAndAddPost(PostService postService, User user) {
        long userId = user.getId();
        Post post = new Post(
                userId,
                "Title %d".formatted(userId),
                "Content",
                user,
                new CopyOnWriteArrayList<>()
        );
        postService.addPost(post);
    }

    private static void printRandomPostComments(PostService postService) {
        if (postService.isEmptyPosts() || !random.nextBoolean()) {
            return;
        }

        long randomPostId = getRandomPostId(postService.getPosts().size());
        postService.printPostAndComments(randomPostId);
    }

    private static void deleteRandomPost(PostService postService, User user) {
        if (random.nextBoolean()) {
            List<Post> userPosts = postService.getPostsByAuthor(user.getId());

            if (!userPosts.isEmpty()) {
                Post postToRemove = userPosts.get(
                        random.nextInt(userPosts.size()));

                postService.removePost(postToRemove.getId());
                log.info("Пользователь {} удалил свой пост {}", user.getName(), postToRemove.getId());
            }
        }
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

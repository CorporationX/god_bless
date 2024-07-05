package faang.school.godbless.sprint2.comment;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

/**
 * @author Evgenii Malkov
 */
@Slf4j
public class Main {

    private static final int POOL_SIZE = 8;
    private static final int POSTS_COUNT = 100;
    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(POOL_SIZE);
        PostService postService = new PostService();
        List<User> users = createUsers();
        List<Post> posts = createPosts(users);

        for (int i = 0; i < POSTS_COUNT; i++) {
            addRandomPost(posts, executors, postService);
            removeRandomPost(executors, postService, users);
            addRandomComment(executors, postService, users);
        }
        executors.shutdown();

        try {
            if (!executors.awaitTermination(20, TimeUnit.SECONDS)) {
                executors.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            executors.shutdownNow();
            Thread.currentThread().interrupt();
        }

        log.info("Окончательный список постов");
        for (Post post : postService.getPosts()) {
            log.info(post.toString());
        }

    }

    private static void addRandomPost(List<Post> posts, ExecutorService executors, PostService postService) {
        Random random = new Random();
        int postIndex = random.nextInt(0, posts.size() - 1);
        Post post = posts.get(postIndex);
        executors.submit(() -> postService.addPost(new Post(post.getHeader(), post.getText(), post.getAuthor())));
    }

    private static void removeRandomPost(ExecutorService executors, PostService postService, List<User> users) {
        Random random = new Random();
        int removingPostId = random.nextInt(0, POSTS_COUNT);
        int userIndex = random.nextInt(0, users.size() - 1);
        User user = users.get(userIndex);
        executors.submit(() -> postService.deletePost(user.getUsername(), removingPostId));
    }

    private static void addRandomComment(ExecutorService executors, PostService postService, List<User> users) {
        Random random = new Random();
        for (int j = 0; j < 5; j++) {
            int commentPostId = random.nextInt(0, POSTS_COUNT);
            int commentUserIndex = random.nextInt(0, users.size() - 1);
            executors.submit(() -> postService.addComment(
                    commentPostId,
                    new Comment(commentPostId + "comment", System.currentTimeMillis(), users.get(commentUserIndex))));
        }
    }

    private static List<User> createUsers() {
        return List.of(
                new User("User1"),
                new User("User2"),
                new User("User3"),
                new User("User4"),
                new User("User5"));
    }

    private static List<Post> createPosts(List<User> users) {
        Random random = new Random();
        return LongStream.range(0, 10)
                .mapToObj((i) ->
                        new Post("Header",
                                "SomeText",
                                users.get(random.nextInt(0, users.size() - 1)))).toList();
    }
}

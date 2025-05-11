package school.faang.facebook;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final String[] USERS = {"user1", "user2", "user3"};
    private static final String[] COMMENT_TEXTS = {
            "comment#1",
            "comment#2",
            "comment#3",
            "comment#4",
            "comment#5"
    };

    private static final Random random = new Random();
    private static final PostService postService = new PostService();
    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        List<Runnable> tasks = new ArrayList<>();
        for (int postId  = 1; postId  <= 8; postId++) {
            tasks.add(createPostTask(postId, "Post " + postId, "Content " + postId, randomUser()));
        }

        List<Comment> createdComments = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            int postId = random.nextInt(8) + 1;
            Comment comment = randomComment();
            tasks.add(addCommentTask(postId, comment));
            createdComments.add(comment);
        }

        tasks.add(removePostTask(1, "user1"));
        tasks.add(removePostTask(1, "user2"));
        tasks.add(removePostTask(1, "user3"));

        for (int i = 0; i < 10; i++) {
            Comment commentToRemove = createdComments.get(random.nextInt(createdComments.size()));
            int postId = random.nextInt(8) + 1;
            String requester = random.nextBoolean()
                    ? commentToRemove.getAuthor()
                    : randomUser();
            tasks.add(removeCommentTask(postId, commentToRemove, requester));
        }

        List<CompletableFuture<Void>> futures = tasks.stream()
                .map(task -> CompletableFuture.runAsync(task, executor))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRunAsync(Main::logFinal, executor)
                .join();

        executor.shutdown();
    }

    private static Runnable createPostTask(int id, String title, String content, String author) {
        return () -> {
            postService.addPost(new Post(id, title, content, author));
            log.info("Добавлен пост {} от {}",
                    title,
                    author);
        };
    }

    private static String randomUser() {
        return USERS[random.nextInt(USERS.length)];
    }

    private static Runnable addCommentTask(int postId, Comment comment) {
        return () -> {
            postService.addComment(postId, comment);
            log.info("Добавление коммента к посту {}: {} (автор: {})",
                    postId,
                    comment.getText(),
                    comment.getAuthor());
        };
    }

    private static Comment randomComment() {
        return new Comment(
                COMMENT_TEXTS[random.nextInt(COMMENT_TEXTS.length)],
                randomUser()
        );
    }

    private static Runnable removePostTask(int postId, String requester) {
        return () -> {
            boolean success = postService.removePost(postId, requester);
            log.info("Удаление поста {} пользователем {}: {}",
                    postId,
                    requester,
                    success);
        };
    }

    private static Runnable removeCommentTask(int postId, Comment comment, String requester) {
        return () -> {
            boolean success = postService.removeComment(postId, comment, requester);
            log.info("Удаление коммента {} из поста {} пользователем {}: {}",
                    comment.getText(),
                    postId,
                    requester,
                    success);
        };
    }

    private static void logFinal() {
        log.info("Итоговое состояние:");
        List<Post> allPosts = postService.getAllPosts();
        if (allPosts.isEmpty()) {
            log.info("Нет постов");
        } else {
            allPosts.forEach(post -> {
                log.info("{} (id:{}) от {}",
                        post.getTitle(),
                        post.getId(),
                        post.getAuthor());
                post.getComments().forEach(comment ->
                        log.info("  {}: {}",
                                comment.getAuthor(),
                                comment.getText()));
            });
        }
    }
}

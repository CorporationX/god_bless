package bjs2_62563;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int TIMEOUT_SECOND = 3;

    public static void main(String[] args) {
        var postService = new PostService();
        var authors = List.of("Александр", "Иван", "Павел", "Аня");
        var executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        var postIds = new ConcurrentSkipListSet<Integer>();

        for (int i = 0; i < authors.size(); i++) {
            var authorIndex = i;
            executor.submit(() -> addPost(authorIndex, authors, postIds, authors.get(authorIndex), postService));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT_SECOND, TimeUnit.SECONDS)) {
                processTimeout(executor);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }

        executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        deletePosts(postIds, authors, executor, postService);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT_SECOND, TimeUnit.SECONDS)) {
                processTimeout(executor);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }

    private static void processTimeout(ExecutorService executor) {
        log.error("Операция не завершилась за заданный таймаут");
        executor.shutdownNow();
    }

    private static void addPost(
            int authorIndex,
            List<String> authors,
            ConcurrentSkipListSet<Integer> postIds,
            String author,
            PostService postService) {
        postIds.add(authorIndex);
        var post = new Post(
                authorIndex,
                String.format("Заголок поста %d", authorIndex),
                String.format("Важное мнение автора %s", author),
                author);
        postService.addPost(post);

        authors.stream()
                .filter(x -> !x.equals(author))
                .forEach(commentAuthor -> postService.addComment(
                        authorIndex,
                        new Comment(
                                String.format("Важный коммент от %s", commentAuthor),
                                commentAuthor,
                                LocalDateTime.now())));

        postService.showPosts();
    }

    private static void deletePosts(
            ConcurrentSkipListSet<Integer> postIds,
            List<String> authors,
            ExecutorService executor,
            PostService postService) {
        for (var postId : postIds) {
            for (var postAuthor : authors) {
                executor.submit(() -> {
                    if (postService.deletePost(postId, postAuthor)) {
                        log.info("Пост {} удалён. ", postId);
                        postService.showPosts();
                    } else {
                        log.info("Пост {} не удалён. Автор {}", postId, postAuthor);
                    }
                });
            }
        }
    }
}

package school.faang.sprint4.bjs_51440;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        PostService postService = new PostService();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Post> posts = List.of(
                new Post(1, "Первый пост", "Содержимое первого поста", "User1"),
                new Post(2, "Второй пост", "Содержимое второго поста", "User2"),
                new Post(2, "Третий пост", "Содержимое третьего поста", "User3"),
                new Post(2, "Четвертый пост", "Содержимое четвертого поста", "User4"),
                new Post(2, "Пятый пост", "Содержимое пятого поста", "User5"),
                new Post(2, "Шестой пост", "Содержимое шестого поста", "User6")
        );

        List<Comment> comments = List.of(
                new Comment("Отличный пост!", "User7", LocalDateTime.now()),
                new Comment("Согласен с автором", "User8", LocalDateTime.now()),
                new Comment("Хорошая статья", "User9", LocalDateTime.now()),
                new Comment("Бесспорно согласен", "User10", LocalDateTime.now()),
                new Comment("Я бы добавил, но нечего", "User11", LocalDateTime.now()),
                new Comment(":)", "User12", LocalDateTime.now())
        );


        List<CompletableFuture<Void>> postsFutures = posts.stream()
                .map(post -> CompletableFuture.runAsync(() -> {
                    postService.addPost(post);
                    log.info("Пользователь {} добавил пост {}", post.getAuthor(), post.getTitle());
                }))
                .toList();

        CompletableFuture.allOf(postsFutures.toArray(new CompletableFuture[0])).join();

        List<CompletableFuture<Void>> commentsFutures = comments.stream()
                .map(comment -> CompletableFuture.runAsync(() -> {
                    int postId = (comments.indexOf(comment) % posts.size()) + 1;
                    postService.addComment(postId, comment);
                    log.info("Пользователь {} добавил комментарий к посту {}",
                            comment.author(), posts.get(postId - 1).getAuthor());
                }))
                .toList();

        CompletableFuture.allOf(commentsFutures.toArray(new CompletableFuture[0])).join();

        CompletableFuture<Void> deletePostFuture = CompletableFuture.runAsync(() -> {
            Post post = getRandomPost(posts);
            postService.deletePost(post.getId(), post.getAuthor());
            log.info("Пользователь {} удалил пост {}", post.getAuthor(), post.getTitle());
        });

        CompletableFuture.allOf(deletePostFuture).join();

        CompletableFuture<Void> deleteCommentFuture = CompletableFuture.runAsync(() -> {
            Post post = getRandomPost(posts);
            Comment comment = getRandomComment(comments);

            postService.deleteComment(post.getId(), comment.timestamp(), comment.author());
            log.info("Пользователь {} удалил комментарий к посту {}", comment.author(), post.getAuthor());
        });

        CompletableFuture.allOf(deleteCommentFuture).join();

        log.info("Все операции завершены");
    }

    private static Post getRandomPost(List<Post> posts) {
        int randomIndex = RANDOM.nextInt(posts.size());
        return posts.get(randomIndex);
    }

    private static Comment getRandomComment(List<Comment> comments) {
        int randomIndex = RANDOM.nextInt(comments.size());
        return comments.get(randomIndex);
    }
}

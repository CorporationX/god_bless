package school.faang.leaveacomment;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class Main {
    public static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        PostService postService = new PostService();

        List<Comment> comments = List.of(
                new Comment("Отличная статья, спасибо за информацию!",
                        "Пользователь1",
                        LocalDateTime.now()),
                new Comment("Интересно, но можно ли узнать больше деталей?",
                        "Пользователь2",
                        LocalDateTime.now()),
                new Comment("Согласен с предыдущим комментарием, хотелось бы узнать больше.",
                        "Пользователь3",
                        LocalDateTime.now()),
                new Comment("Прекрасные фотографии! Спасибо за публикацию.",
                        "Charlie",
                        LocalDateTime.now())
        );

        List<Post> posts = List.of(
                new Post(1, "Путешествие в Италию",
                        "Описание моего недавнего путешествия в Италию...",
                        "Alice"),
                new Post(2, "Рецепт торта 'Медовик'",
                        "Шаг за шагом инструкция по приготовлению вкусного торта 'Медовик'",
                        "Bob")
        );

        List<CompletableFuture<Void>> postFutures = posts.stream()
                .map(post -> CompletableFuture.runAsync(() -> postService.addPost(post)))
                .toList();

        CompletableFuture.allOf(postFutures.toArray(new CompletableFuture[0])).join();

        List<CompletableFuture<Void>> commentFutures = comments.stream()
                .map(comment -> CompletableFuture.runAsync(() -> {
                    int postId = RANDOM.nextInt(posts.size());
                    postService.addComment(postId, comment);
                }))
                .toList();

        CompletableFuture.allOf(commentFutures.toArray(new CompletableFuture[0])).join();

        log.info("Все посты и комменты были добавлены.");
    }
}

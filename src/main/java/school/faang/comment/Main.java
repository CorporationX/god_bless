package school.faang.comment;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

import static school.faang.comment.ThreadPoolProvider.executor;

@Slf4j
public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        List<Post> posts = List.of(
                new Post(1, "Основы Java", "Введение в программирование на Java.", "Дмитрий"),
                new Post(2, "Принципы ООП", "Инкапсуляция, наследование и полиморфизм.", "Мария"),
                new Post(3, "Введение в Spring Boot", "Как начать использовать Spring Boot.", "Иван"),
                new Post(4, "REST API", "Создание RESTful сервисов на Java.", "Олег"),
                new Post(5, "Коллекции в Java", "Обзор коллекций Java.", "Светлана")
        );
        List<Comment> comments = List.of(
                new Comment(1, "Отличная статья, спасибо!", "Иван"),
                new Comment(2, "Не совсем согласен с выводами.", "Мария"),
                new Comment(3, "Очень полезно, жду продолжения.", "Олег"),
                new Comment(4, "Добавьте больше примеров, пожалуйста.", "Светлана"),
                new Comment(5, "Круто! Всё понятно объяснено.", "Дмитрий")
        );

        List<CompletableFuture<Void>> postAddedFutures = posts.stream()
                .map(post -> CompletableFuture.runAsync(() -> postService.addPost(post), executor))
                .toList();
        try {
            CompletableFuture.allOf(postAddedFutures.toArray(new CompletableFuture[0])).join();
            log.debug("All posts added");
        } catch (RuntimeException e) {
            log.error("Exception was thrown while executing tasks", e);
        }

        BiFunction<Integer, Comment, CompletableFuture<Void>> addCommentFunction = (postId, comment) ->
                CompletableFuture.runAsync(() -> postService.addComment(postId, comment), executor);

        List<CompletableFuture<Void>> commentAddedFutures = new ArrayList<>();
        commentAddedFutures.add(addCommentFunction.apply(posts.get(0).getId(), comments.get(0)));
        commentAddedFutures.add(addCommentFunction.apply(posts.get(0).getId(), comments.get(1)));
        commentAddedFutures.add(addCommentFunction.apply(posts.get(0).getId(), comments.get(2)));
        commentAddedFutures.add(addCommentFunction.apply(posts.get(1).getId(), comments.get(0)));
        try {
            CompletableFuture.allOf(commentAddedFutures.toArray(new CompletableFuture[0])).join();
            log.debug("All comments added");
        } catch (RuntimeException e) {
            log.error("Exception was thrown while executing tasks", e);
        }

        List<CompletableFuture<Void>> deleteObjectsFutures = new ArrayList<>();
        deleteObjectsFutures.add(CompletableFuture.runAsync(() ->
                postService.deletePost(posts.get(0).getId(), "Мария"), executor));
        deleteObjectsFutures.add(CompletableFuture.runAsync(() ->
                postService.deletePost(posts.get(0).getId(), "Дмитрий"), executor));
        deleteObjectsFutures.add(CompletableFuture.runAsync(() ->
                postService.deleteComment(posts.get(0).getId(), comments.get(0).getId(), "Олег"), executor));
        deleteObjectsFutures.add(CompletableFuture.runAsync(() ->
                postService.deleteComment(posts.get(0).getId(), comments.get(0).getId(), "Иван"), executor));
        try {
            CompletableFuture.allOf(deleteObjectsFutures.toArray(new CompletableFuture[0])).join();
            log.debug("All delete methods executed");
        } catch (RuntimeException e) {
            log.error("Exception was thrown while executing tasks", e);
        }

        ThreadPoolProvider.gracefullyShutdown();
        System.out.println("The end of the program");
    }
}

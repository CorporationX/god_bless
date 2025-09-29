package bjs2_93615;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PostService service = new PostService();

        Map<Integer, Post> postsToAdd = Map.of(
                1, new Post(1, "Первый пост", "Всем привет!", "Ваня"),
                2, new Post(2, "Второй пост", "Сегодня отличная погода", "Саша")
        );

        Map<Integer, List<Comment>> commentsToAdd = Map.of(
                1, List.of(
                        new Comment("Круто!", "Петя"),
                        new Comment("Согласен!", "Дима")
                ),
                2, List.of(
                        new Comment("Поддерживаю!", "Ваня")
                )
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);

        postsToAdd.values().forEach(post ->
                executor.submit(() -> service.addPost(post))
        );

        commentsToAdd.forEach((postId, comments) ->
                comments.forEach(comment ->
                        executor.submit(() -> service.addComment(postId, comment)))
        );

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Посты и комментарии после добавления");
        service.showAllPosts();

        System.out.println("\nПопытка удалить комментарий Ваня в посте id=2 пользователем Саша:");
        LocalDateTime userCommentTime = commentsToAdd.get(2).get(0).getTimestamp();
        service.deleteComment(2, userCommentTime, "Саша");

        System.out.println("\nУдаляем комментарий от Дима в посте id=1:");
        userCommentTime = commentsToAdd.get(1).get(1).getTimestamp();
        service.deleteComment(1, userCommentTime, "Дима");
        service.showAllPosts();

        System.out.println("\nПопытка удалить пост с id=2 чужим автором Петя:");
        service.deletePost(2, "Петя");
        service.showAllPosts();

        System.out.println("\nУдаляем пост с id=1 автором Ваня:");
        service.deletePost(1, "Ваня");
        service.showAllPosts();

    }
}
package faang.school.godbless.multi_con.task1comment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            futures.add(CompletableFuture.runAsync(() -> {
                Post post = new Post("Заголовок " + finalI, "Текст поста " + finalI, "Автор " + finalI);
                postService.addPost(post);
            }));
        }

        // Добавление комментариев к постам
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int finalI = i;
                int finalJ = j;
                futures.add(CompletableFuture.runAsync(() -> {
                    Comment comment = new Comment("Комментарий " + finalI, "Комментатор " + finalJ);
                    postService.addComment(finalI, comment);
                }));
            }
        }

       CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("------------------------------------------------------------------------");
        System.out.println(LocalDateTime.now().format(formatter) + " - Текущее состояние списка постов:");
        postService.getPosts().forEach(post -> {
            System.out.println("Пост: " + post.getTitle());
            post.getComments().forEach(comment ->
                    System.out.println(" - Комментарий от " + comment.getAuthor() + ": " + comment.getText())
            );
        });
        System.out.println("------------------------------------------------------------------------");

    }
}


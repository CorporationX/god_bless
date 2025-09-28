package school.faang.bjs2_93700;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        PostService postService = new PostService();
        Post postForChecking = new Post(3, "Кино", "У кого есть желание сходить в кино?", "Аня");
        LocalDateTime timeForChecking = LocalDateTime.now();

        postService.addPost(new Post(1, "Скоро проект",
                "На следующей неделе начинается проект!", "Faang"));
        postService.addPost(new Post(2, "Задачи",
                "Задачи топ! Увидимся на проекте", "Олег"));
        postService.addComment(3, new Comment("Не верится, что уже прошел месяц", "Максим",
                LocalDateTime.now()));
        postService.addComment(1, new Comment("Не верится, что уже прошел месяц", "Максим",
                LocalDateTime.now()));
        postService.addComment(2, new Comment("Задачи тоже нравятся", "Артем", LocalDateTime.now()));
        postService.addPost(postForChecking);
        postService.addComment(3, new Comment("У меня есть желание", "Виталий",
                LocalDateTime.now()));
        postService.addComment(3, new Comment("Я бы тоже сходила", "Алла", timeForChecking));
        postService.watchPostsAndComments();
        postService.deleteComment(3, new Comment("Я бы сходила", "Алла", timeForChecking));
        postService.deleteComment(3, new Comment("Я бы тоже сходила", "Алла", timeForChecking));
        postService.addComment(3, new Comment("Сегодня вечером занята", "Марина",
                LocalDateTime.now()));
        postService.deletePost(postForChecking);
        postService.deletePost(postForChecking);
        postService.watchPostsAndComments();
        postService.shutdownCorrectly();
    }
}

package school.faang.bjs2_93666;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    private static final int THREAD_COUNT = 5;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_COUNT);

    public static void main(String[] args) {

        Post post1 = new Post(1, "Искусственный интеллект 2024",
                "Новые достижения в области машинного обучения...",
                "Технолог Алексей", new ArrayList<>());
        post1.getComments().add(new Comment("Отличный обзор современных тенденций!", "Мария",
                LocalDate.of(2024, 1, 15)));
        post1.getComments().add(new Comment("Жду статью про этику ИИ", "Этик",
                LocalDate.of(2024, 1, 16)));
        post1.getComments().add(new Comment("GPT-4 действительно впечатляет", "Разработчик",
                LocalDate.of(2024, 1, 17)));
        post1.getComments().add(new Comment("А когда ждать GPT-5?", "Любопытный",
                LocalDate.of(2024, 1, 18)));
        post1.getComments().add(new Comment("Спасибо за полезную информацию!", "Студент",
                LocalDate.of(2024, 1, 19)));

        Post post2 = new Post(2, "Топ-10 мест Японии",
                "Самые красивые и интересные места для посещения...",
                "Путешественник Анна", new ArrayList<>());
        post2.getComments().add(new Comment("Мечтаю посетить Киото!", "Мечтатель",
                LocalDate.of(2024, 2, 10)));
        post2.getComments().add(new Comment("Фудзияма просто великолепна", "Фотограф",
                LocalDate.of(2024, 2, 11)));
        post2.getComments().add(new Comment("А какие там цены на жилье?", "Экономный",
                LocalDate.of(2024, 2, 12)));
        post2.getComments().add(new Comment("Лучшее время для посещения - весна", "Опытный",
                LocalDate.of(2024, 2, 13)));
        post2.getComments().add(new Comment("Спасибо за советы по маршруту!", "Турист",
                LocalDate.of(2024, 2, 14)));
        PostService postService = new PostService();
        postService.addPost(post1);
        postService.removePost(1);
        postService.addPost(post2);
        postService.removeComment(2);
    }
}

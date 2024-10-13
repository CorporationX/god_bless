package school.faang.thebigbangtheory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        List<Task> tasks = List.of(
                new Task("Задача 1", "Уборка"),
                new Task("Задача 2", "Приготовление еды"),
                new Task("Задача 3", "Стирка"),
                new Task("Задача 4", "Чтение книги")
        );
        ExecutorService service = Executors.newFixedThreadPool(2);

        tasks.forEach(service::submit);

        service.shutdown();

        if (!service.awaitTermination(20, TimeUnit.SECONDS)) {
            System.out.println("\nНе предвиденная ошибка");
            service.shutdownNow();
        }
    }
}

package school.faang.bigbangtheory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Task sheldon = new Task("Шелдон", "Подготовка теории");
        Task leonard = new Task("Леонард", "Моделирование эксперимента");
        Task howard = new Task("Говард", "Разработка инструментов");
        Task rajesh = new Task("Раджеш", "Анализ данных");

        executor.submit(sheldon);
        executor.submit(leonard);
        executor.submit(howard);
        executor.submit(rajesh);

        executor.shutdown();
    }
}
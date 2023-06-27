import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Task Task1 = new Task("Шелдон", "подготовка теории");
        Task Task2 = new Task("Леонард", "моделирование эксперимента");
        Task Task3 = new Task("Говард", "разработка инструментов");
        Task Task4 = new Task("Раджеш", "анализ данных");
        executor.submit(Task1);
        executor.submit(Task2);
        executor.submit(Task3);
        executor.submit(Task4);
        executor.shutdown();
    }
}

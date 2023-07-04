import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(new Task("Шелдон", "подготовка теории"));
        executor.execute(new Task("Леонард", "моделирование эксперимента"));
        executor.execute(new Task("Говард", "разработка инструментов"));
        executor.execute(new Task("Раджеш", "анализ данных"));
        executor.shutdown();
    }
}

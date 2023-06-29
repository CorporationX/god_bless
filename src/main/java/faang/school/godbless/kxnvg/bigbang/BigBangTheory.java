package faang.school.godbless.kxnvg.bigbang;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    public static void main(String[] args) {
        Task sheldonTask = new Task("Шелдон", "подготовка теории");
        Task leonardTask = new Task("Леонард", " моделирование эксперимента");
        Task govardTask = new Task("Говард", "разработка инструментов");
        Task radgeshTask = new Task("Раджеш", "анализ данных");

        ExecutorService service = Executors.newFixedThreadPool(4);

        service.execute(sheldonTask);
        service.execute(leonardTask);
        service.execute(govardTask);
        service.execute(radgeshTask);

        service.shutdown();
        try {
            service.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Научный проект готов");
    }
}

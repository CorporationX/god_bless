package faang.school.godbless.BJS2_24355;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {

    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);
        service.execute(new Task("Шелдон", "подготовка теории"));
        service.execute(new Task("Леонард", "моделирование эксперимента"));
        service.execute(new Task("Говард", "разработка инструментов"));
        service.execute(new Task("Раджеш", "анализ данных"));

        service.shutdown();

        try {
            if (service.awaitTermination(2, TimeUnit.SECONDS)) {
                System.out.println("Все задания успешно выполнены!");
            } else
                System.out.println("Внимание! Не все задания были выполнены!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package faang.school.godbless.ThirdSprint.BJS2_26005;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigBangTheory {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(4);
        Task[] tasks = {new Task("Шелдон", "подготовка теории"), new Task("Леонард", "моделирование эксперимента"), new Task("Говард", "разработка инструментов"), new Task("Раджеш", "анализ данных")};

        Arrays.stream(tasks).forEach(t -> service.execute(t));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        service.shutdownNow();
    }
}

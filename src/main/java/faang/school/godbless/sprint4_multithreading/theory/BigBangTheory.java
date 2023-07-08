package faang.school.godbless.sprint4_multithreading.theory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(new Task("Шелдон", "подготовка теории"));
        service.execute(new Task("Леонард", "моделирование эксперимента"));
        service.execute(new Task("Говард", "разработка инструментов"));
        service.execute(new Task("Раджеш", "анализ данных"));
        service.shutdown();

        try {
            service.awaitTermination(10, TimeUnit.MILLISECONDS);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
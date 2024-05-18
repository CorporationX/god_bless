package faang.school.godbless.the.big.bang.theory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BigBangTheory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(new Task("Шелдон", "подготовка теории"));
        executor.execute(new Task("Леонард", "моделирование эксперимента"));
        executor.execute(new Task("Говард", "разработка инструментов"));
        executor.execute(new Task("Раджеш", "анализ данных"));
        executor.shutdown();

        if(executor.awaitTermination(6, SECONDS)) {
            System.out.println("Задачи сделаны");
        }
    }
}

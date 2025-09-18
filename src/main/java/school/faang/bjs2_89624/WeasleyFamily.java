package school.faang.bjs2_89624;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] DAILY_CHORE = {
            "помыть посуду", "подмести пол", "приготовить ужин",
            "включить котел", "постирать вещи", "купить новые мантии",
            "убраться в саду", "уничтожить ненужный хлам", "помыть отцовскую машину"
    };

    private static final int ONE_MINUTE_WAITING = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : DAILY_CHORE) {
            executor.execute(new Chore(chore));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(ONE_MINUTE_WAITING, TimeUnit.MINUTES)) {
                System.out.println("День подходит к концу - Перси не может ждать вечно. Потоки приостановлены.");
                executor.shutdownNow();
            } else {
                System.out.println("Отлично, все потоки Перси успели вовремя. Все задачи на сегодня выполнены!");
            }
        } catch (InterruptedException e) {
            System.out.println("Перси прервали пока он следил за потоками! Волшебные потоки остановлены.");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

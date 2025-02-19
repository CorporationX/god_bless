package weasley;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "помыть посуду",
                "подмести пол",
                "приготовить ужин",
                "почистить камин",
                "пистирать мантии"
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executorService.submit(new Chore(chore));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за 5 минут, завершаем принудительно.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("Все задачи завершены!");
    }
}

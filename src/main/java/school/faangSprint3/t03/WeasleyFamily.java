package school.faangSprint3.t03;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = Arrays.asList("помыть посуду", "подмести пол", "приготовить ужин");

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String choreName : chores) {
            Chore chore = new Chore(choreName);
            executor.submit(chore);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("Все задачи выполнены!");
    }
}
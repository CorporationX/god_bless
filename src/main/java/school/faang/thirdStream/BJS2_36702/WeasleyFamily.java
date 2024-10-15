package school.faang.thirdStream.BJS2_36702;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = List.of("помыть посуду", "подмести пол", "приготовить ужин", "постирать вещи");

        ExecutorService executorService = Executors.newCachedThreadPool();
        chores.stream().map(Chore::new).forEach(executorService::execute);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}

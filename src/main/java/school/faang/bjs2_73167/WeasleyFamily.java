package school.faang.bjs2_73167;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private final static int minutesToWait = 5;
    private final static List<String> choreList = List.of("Wash dishes", "Take out the trash",
            "Fly to the moon", "Create new thing");
    public static void main(String[] args) {
        List<Chore> chores = choreList.stream().map(Chore::new).toList();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executorService.submit(chore);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(minutesToWait, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}

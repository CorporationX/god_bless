package school.faang.nice_but_poor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Chore> chores = weasleyFamily.getChores().stream().map(Chore::new).toList();
        for (Chore chore : chores) {
            executorService.submit(chore);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        System.out.println("Все задачи выполнены");
    }
}

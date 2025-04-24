package school.faang.nice_but_poor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int TIMEOUT = 3000;

    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Chore> chores = weasleyFamily.getChores().stream().map(Chore::new).toList();
        chores.forEach(executorService::execute);

        executorService.shutdown();
        try {
            executorService.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        System.out.println("Все задачи выполнены");
    }
}

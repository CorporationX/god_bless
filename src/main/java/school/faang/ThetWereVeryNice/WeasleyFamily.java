package school.faang.ThetWereVeryNice;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    static List<String> chores = List.of("помыть посуду", "подмести пол", "приготовить ужин");
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(String exersice: chores) {
            Chore chore = new Chore(exersice);
            executorService.execute(chore);
        }
        try {
            if (!executorService.awaitTermination(4, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException ignored) {
            executorService.shutdownNow();
            System.out.println("Основной поток был прерван");
            Thread.currentThread().interrupt();
        }
    }
}

package school.faang.extremelypoor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
        List<Chore> chores = List.of(
                new Chore("помыть посуду"),
                new Chore("подмести пол"),
                new Chore("приготовить ужин")
        );
        ExecutorService service = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            service.submit(chore);
        }

        service.shutdown();

        if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
            System.out.println("Опять что то отвалилось");
            service.shutdownNow();
        }
    }
}

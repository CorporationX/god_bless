package school.faang.TheyWereNice;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
        List<Chore> chores = List.of(
                new Chore("Chore I"),
                new Chore("Chore II"),
                new Chore("Chore III")
        );

        ExecutorService service = Executors.newCachedThreadPool();

        chores.forEach(service::execute);

        service.shutdown();

        if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
            System.out.println("Something went wrong");
            service.shutdownNow();
        }
        System.out.println("Done!!!");
    }
}

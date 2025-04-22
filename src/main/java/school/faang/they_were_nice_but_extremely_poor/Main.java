package school.faang.they_were_nice_but_extremely_poor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        WeasleyFamily weasleyFamily = new WeasleyFamily(new ArrayList<>(List.of(
                new Chore("Найти машину в запретном лесу"),
                new Chore("Приготовить обед"),
                new Chore("Отправить сову в министерство"),
                new Chore("Победить воландеморта"),
                new Chore("Починить палочку Рона"))));

        for (Chore chore : weasleyFamily.chores()) {
            executor.submit(chore);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}

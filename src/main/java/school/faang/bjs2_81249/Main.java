package school.faang.bjs2_81249;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily family = new WeasleyFamily();
        family.addChores(List.of(new Chore("washing the dishes"),
                new Chore("mopping the floor"), new Chore("cooking dinner")));
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Chore chore : family.getChores()) {
            executorService.execute(chore);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Chores are not done in one minute? You're grounded...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}

package school.faang.but_extremly;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final int TIMEOUT = 60;
        ExecutorService executorService = Executors.newCachedThreadPool();
        WeasleyFamily weasleyFamily = new WeasleyFamily();

        for (String task : weasleyFamily.getChores()) {
            executorService.submit(new Chore(task));
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS);

            if (executorService.isTerminated()) {
                System.out.println("All Tasks Completed");
            } else {
                System.out.println("No All Tasks Was Completed");
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR");
            e.printStackTrace();
            executorService.shutdownNow();
        }

    }
}

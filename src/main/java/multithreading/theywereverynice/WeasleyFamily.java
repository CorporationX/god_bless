package multithreading.theywereverynice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {

    private static final String[] chores = {"Dishes", "Windows", "Floor", "Surfaces"};

    static ExecutorService executorService = Executors.newFixedThreadPool(chores.length);

    public static void main(String[] args) {
        for (int i = 0; i < chores.length; i++) {
            Chore chore = new Chore(chores[i]);
            executorService.submit(chore);

            if (executorService.isTerminated()) {
                executorService.shutdown();
            }
        }
    }
}

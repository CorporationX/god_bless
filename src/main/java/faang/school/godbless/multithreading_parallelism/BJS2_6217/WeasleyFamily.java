package faang.school.godbless.multithreading_parallelism.BJS2_6217;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Wash the dishes", "Wash the clothes", "Iron the shirts", "Clean the floors", "Cook dinner"};

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String chore : chores) {
            executorService.execute(new Chore(chore));
        }

        executorService.shutdown();
    }
}

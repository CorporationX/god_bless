package faang.school.godbless.nice_but_extrmely_poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Wash the dishes", "Wash clothes", "Iron shirts", "Wash the floors", "Cook dinner"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executorService.submit(new Chore(chore));
        }
        executorService.shutdown();
    }
}

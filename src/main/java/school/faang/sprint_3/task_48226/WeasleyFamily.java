package school.faang.sprint_3.task_48226;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    private final String[] chores = generateChores();

    private String[] generateChores() {
        String[] result = new String[new Random(1).nextInt(100)];

        for (int i = 0; i < result.length; i++) {
            result[i] = "Chore" + (i + 1);
        }
        return result;
    }

    public void completeChores() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            for (String chore : chores) {
                executorService.submit(new Chore(chore));
            }
        } finally {
            executorService.shutdown();
        }
    }
}

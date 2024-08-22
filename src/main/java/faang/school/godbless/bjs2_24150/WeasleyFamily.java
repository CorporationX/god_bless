package faang.school.godbless.bjs2_24150;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] tasks = new String[]{
                "cleaning",
                "cooking",
                "dish washing",
                "do laundry",
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String task : tasks) {
            Chore chore = new Chore(task);
            executorService.execute(chore);
        }

        executorService.shutdown();
    }
}

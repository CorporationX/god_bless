package faang.school.godbless.sprint3.BJS2_23965;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {
                "Wash dishes",
                "Clean table",
                "Clean up Ron's room"
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore task = new Chore(chore);
            executorService.execute(task);
        }

        executorService.shutdown();
    }
}

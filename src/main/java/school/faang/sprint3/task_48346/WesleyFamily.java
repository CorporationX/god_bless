package school.faang.sprint3.task_48346;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WesleyFamily {

    private static final String[] CHORES = new String[]{
            "Clean dishes",
            "Clean floor",
            "Cook",
            "Throw away the trash",
            "Buy grocery"
    };

    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();

        for (String chore : CHORES) {
            pool.submit(new Chore(chore));
        }

        pool.shutdown();
    }
}

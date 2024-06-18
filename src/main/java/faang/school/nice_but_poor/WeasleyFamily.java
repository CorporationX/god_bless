package faang.school.nice_but_poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = new String[]{"Clean the house", "Fix magic clocks", "Wash the dishes",
                "Cook the meal"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore choreToExecute = new Chore(chore);
            executorService.execute(choreToExecute);
        }

        executorService.shutdown();
    }
}

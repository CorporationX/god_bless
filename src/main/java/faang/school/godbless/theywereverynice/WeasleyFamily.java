package faang.school.godbless.theywereverynice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = new String[]{
                "Take out the garbage",
                "Clothes washing",
                "Prepare the food",
                "Broom repair",
                "Vacuum",
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (String task : chores) {
            Chore chore = new Chore(task);
            executorService.execute(chore);
        }
        executorService.shutdown();
    }
}
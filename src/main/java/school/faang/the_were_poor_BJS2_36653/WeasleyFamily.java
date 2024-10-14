package school.faang.the_were_poor_BJS2_36653;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        Chore[] chores = {new Chore("Wash the dishes"),
                new Chore("Take out the trash"),
                new Chore("Vacuum the living room"),
                new Chore("Do the laundry"),
                new Chore("Mow the lawn")};

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executorService.submit(chore);
        }
        executorService.shutdown();
    }
}

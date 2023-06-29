package faang.school.godbless.theyWere;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class WeasleyFamily {
    public static void main(String[] args) {

        String[] chores = {"Wash the dishes", "Do the laundry", "Iron the shirts", "Wash the floors", "Cook dinner"};

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            Chore task = new Chore(chore);
            executor.execute(task);
        }

        executor.shutdown();
    }
}

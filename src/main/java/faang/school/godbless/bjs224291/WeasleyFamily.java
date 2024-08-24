package faang.school.godbless.bjs224291;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Wash the dishes", "Do the laundry", "Iron the shirts", "Mop the floors", "Cook dinner"};
        ExecutorService executor = Executors.newCachedThreadPool();
        for (var chore : chores) {
            executor.execute(new Chore(chore));
        }
        executor.shutdown();
    }
}
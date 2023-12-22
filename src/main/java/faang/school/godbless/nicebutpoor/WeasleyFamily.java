package faang.school.godbless.nicebutpoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"Cleaning bathrooms", "Taking out the trash", "Making the bed", "Clear the table"};
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (String chore : chores) {
            cachedThreadPool.execute(new Chore(chore));
        }
        cachedThreadPool.shutdown();
    }
}

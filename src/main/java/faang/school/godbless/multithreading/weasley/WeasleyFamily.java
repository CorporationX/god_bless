package faang.school.godbless.multithreading.weasley;

import java.util.concurrent.Executors;

public class WeasleyFamily {

    public static void main(String[] args) {
        String[] chores = new String[] {"sweeping", "cleaning", "cooking", "washing", "repairing"};
        var threadPool = Executors.newCachedThreadPool();
        for (String chore : chores) {
            threadPool.execute(new Chore(chore));
        }
        threadPool.shutdown();
    }
}

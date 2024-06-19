package faang.school.godbless.multithreading.verynice;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {

        Chore[] chores = new Chore[]{
                new Chore("Enchanting Brooms for Sweeping"),
                new Chore("Brewing Potions for Cleaning"),
                new Chore("Summoning Dinner Ingredients"),
                new Chore("Charms for Dusting Shelves"),
                new Chore("Laundry Sorting Spells")
        };

        ExecutorService threadPool = Executors.newCachedThreadPool();

        Arrays.stream(chores)
                .forEach(threadPool::submit);

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.MINUTES);
    }
}

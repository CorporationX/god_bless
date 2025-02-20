package school.faang.sprint3.multithreading.bjs2_60900;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Chore[] chores = new Chore[]{
                new Chore("Wash the dishes"),
                new Chore("Sweep the floor"),
                new Chore("Cook dinner"),
                new Chore("Do the laundry"),
                new Chore("Take out the trash"),
                new Chore("Water the plants")
        };
        WeasleyFamily family = new WeasleyFamily(chores);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Chore chore : family.getChores()) {
            executorService.execute(chore);
        }
        executorService.shutdown();
    }
}

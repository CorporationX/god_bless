package faang.school.godbless.Multithreading.SynchronizationWaitNotify.task04_SuperCow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int MAX_THREAD = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREAD);
        var players = List.of(
                new Player("Cucumber2017"),
                new Player("XCarrotX"),
                new Player("Watermelon2001"),
                new Player("SpicyTomato"),
                new Player("SausageLover"));

        Boss boss = new Boss(3);

        for (Player player : players) {
            player.startBattle(boss);
        }
    }
}

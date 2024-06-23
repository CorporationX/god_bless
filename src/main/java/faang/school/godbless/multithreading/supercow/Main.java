package faang.school.godbless.multithreading.supercow;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(2);
        var playerList = List.of(
                new Player("Gamer1"),
                new Player("Gamer2"),
                new Player("Gamer3"),
                new Player("Gamer4"),
                new Player("Gamer5"),
                new Player("Gamer6"),
                new Player("Gamer7"),
                new Player("Gamer8"));

        var threadPool = Executors.newFixedThreadPool(5);
        playerList.forEach(player ->
                threadPool.submit(() -> player.startBattle(boss)));

        threadPool.shutdown();
        threadPool.awaitTermination(10, TimeUnit.SECONDS);
    }
}

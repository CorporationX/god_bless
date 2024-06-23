package faang.school.godbless.synchronization;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss();
        Players playersOne = new Players("Alex");
        Players playersTwo = new Players("Bob");
        Players playersThree = new Players("Charlie");
        Players playersFour = new Players("David");
        Players playersFive = new Players("Jack");
        List<Players> playersList = List.of(playersOne, playersTwo, playersThree, playersFour, playersFive);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (Players player : playersList) {
            executorService.submit(() -> player.fightTheBoss(boss));
        }
        executorService.shutdown();
        System.out.println(boss.getCurrentPlayers());
    }
}
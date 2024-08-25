package faang.school.godbless.BJS2_24457;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            players.add(new Player("Player" + i));
        }

        Boss molokosos = new Boss(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (Player player : players) {
            executorService.submit(() -> {
                player.startBattle(molokosos);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                player.finishBattle(molokosos);
            });
        }

        executorService.shutdown();
    }
}

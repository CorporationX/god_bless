package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(10);
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            players.add(new Player("Player" + (i+1)));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(Player player : players) {
            executorService.submit(() -> player.startBattle(boss));
        }
        executorService.shutdown();
    }
}

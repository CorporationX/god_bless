package faang.school.godbless.kxnvg.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SuperCowRunner {

    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss("Доктор Грю", 3);
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            players.add(new Player("Player" + i));
        }

        ExecutorService service = Executors.newFixedThreadPool(5);
        players.forEach(player -> service.submit(() -> player.startBattle(boss)));
        players.get(0).deletePlayer(boss);
        players.get(1).deletePlayer(boss);
        players.get(2).deletePlayer(boss);

        service.shutdown();
        service.awaitTermination(30, TimeUnit.SECONDS);
    }
}

package faang.school.godbless.synchronize.superCow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Boss boss = new Boss(4, 5);

        Player newPlayer1 = new Player("NewGamer 1");
        Player newPlayer2 = new Player("NewGamer 2");
        Player newPlayer3 = new Player("NewGamer 3");

        List<Player> players = List.of(newPlayer1, newPlayer2, newPlayer3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        players.forEach(player -> {
            executorService.execute(() -> player.startBattle(boss));
        });


        executorService.shutdown();
    }
}

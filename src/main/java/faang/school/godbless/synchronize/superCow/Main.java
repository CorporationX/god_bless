package faang.school.godbless.synchronize.superCow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Boss boss = new Boss();

        List<Player> players = getPlayers();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        players.forEach(player -> {
            executorService.execute(() -> player.startBattle(boss));
        });

        executorService.shutdown();
    }

    private static List<Player> getPlayers() {
        Player newPlayer1 = new Player("NewGamer 1");
        Player newPlayer2 = new Player("NewGamer 2");
        Player newPlayer3 = new Player("NewGamer 3");
        Player newPlayer4 = new Player("NewGamer 4");
        Player newPlayer5 = new Player("NewGamer 5");
        Player newPlayer6 = new Player("NewGamer 6");

        return List.of(
                newPlayer1, newPlayer2, newPlayer3, newPlayer4, newPlayer5, newPlayer6
        );
    }
}

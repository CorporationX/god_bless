package supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        int numberOfPlayers = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfPlayers);

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("Воин " + i, boss));
        }

        players.forEach(executorService::execute);

        executorService.shutdown();
    }
}

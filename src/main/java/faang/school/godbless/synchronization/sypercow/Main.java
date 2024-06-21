package faang.school.godbless.synchronization.sypercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int MAX_NUMBER_PLAYER_ATTACKED = 3;
    private static final int MAX_PLAYERS = 10;
    private static final int MAX_POOL_SIZE = 2;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_NUMBER_PLAYER_ATTACKED);
        ExecutorService executor = Executors.newFixedThreadPool(MAX_POOL_SIZE);
        List<Player> players = getPlayers();
        for(Player player : players){
            executor.submit(() -> player.startBattle(boss));
        }
        executor.shutdown();
    }

    public static List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        int numberOfPlayer = (int) (Math.random() * MAX_PLAYERS + 1);
        for (int i = 1; i <= numberOfPlayer; i++) {
            players.add(new Player("Player #" + i));
        }
        return players;
    }
}

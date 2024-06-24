package faang.school.godbless.synchronization.bro_force;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int POOL_SIZE = 3;

    public static void main(String[] args) {
        Game game = new Game();
        List<Player> players = getPlayers();
        players.stream().forEach(game::addPlayer);
        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        for (Player player : game.getPlayers()) {
            while (game.getCountActivePlayer() != 0) {
                executor.submit(game::update);
            }
        }
        executor.shutdown();
    }

    private static List<Player> getPlayers() {
        return List.of(new Player("Misha", 5),
                new Player("Jane", 7),
                new Player("Bob", 8));
    }

}

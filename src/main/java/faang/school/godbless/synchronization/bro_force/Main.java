package faang.school.godbless.synchronization.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player firstPlayer = new Player("Misha", 5);
        Player secondPlayer = new Player("Jane", 7);
        Player thirdPlayer = new Player("Bob", 8);
        game.addPlayer(firstPlayer);
        game.addPlayer(secondPlayer);
        game.addPlayer(thirdPlayer);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (Player player : game.getPlayers()) {
            while (game.isPlaying()) {
                executor.submit(game::update);
            }
        }
        executor.shutdown();
    }
}

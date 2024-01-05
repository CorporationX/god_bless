package faang.school.godbless.BroForce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static faang.school.godbless.BroForce.Game.players;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        players.add(new Player("Player1", 5));
        players.add(new Player("Player2", 5));

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < players.size(); i++) {
            executorService.submit(game::update);
        }
        executorService.shutdown();
    }
}

package faang.school.godbless.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Game game = new Game(game.getPlayers());

        Player firstPlayer = new Player("Axe", 10,true);
        Player secondPlayer = new Player("Drow", 4,true);

        game.addPlayer(firstPlayer);
        game.addPlayer(secondPlayer);


        ExecutorService poolThreads = Executors.newFixedThreadPool(3);

        for (int i = 0; i < game.getPlayers().size(); i++) {
            poolThreads.submit(() -> {
                while (firstPlayer.getLives() > 0 && secondPlayer.getLives() > 0) {
                    game.update();
                }
            });
        }
    }
}

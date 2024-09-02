package faang.school.godbless.BJS224253;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player beks = new Player("beks", 10);
        Player aru = new Player("aru", 12);
        List<Player> bros = new ArrayList<>(List.of(beks, aru));
        bros.forEach(game::addPlayer);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        while (game.getActivePlayersCounter() > 0 && !game.isGameOver()) {
            executorService.submit(game::update);
        }
        executorService.shutdown();
    }
}

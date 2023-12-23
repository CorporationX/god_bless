package faang.school.godbless.bro_forse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Game game = getGame();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            executor.submit(game::update);

        }
    }

    private static Game getGame() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("1q", 5));
        players.add(new Player("2q", 8));
        return new Game(players);
    }
}

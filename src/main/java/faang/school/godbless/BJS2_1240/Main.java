package faang.school.godbless.BJS2_1240;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>(List.of(
                new Player("Edisolt", 9),
                new Player("Vlad", 5)));
        Game game = new Game(players);

        ExecutorService executorService = Executors.newFixedThreadPool(12);

        for (int i = 0; i < players.size(); i++) {
            executorService.submit(game::update);
        }

        executorService.shutdown();
    }
}
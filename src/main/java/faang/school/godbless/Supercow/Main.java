package faang.school.godbless.Supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Boss boss = new Boss(3);
        List<Player> players = List.of(
                new Player("Kirill"),
                new Player("Petr"),
                new Player("Pavel"),
                new Player("Ivan"),
                new Player("Sacha"));

        players.forEach( player -> executorService.execute(() -> {
            try {
                player.startBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));
        executorService.shutdown();
    }
}

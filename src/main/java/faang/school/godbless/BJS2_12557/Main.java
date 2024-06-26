package faang.school.godbless.BJS2_12557;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();
        List<Player> players = List.of(new Player("первый игрок"),
                new Player("второй игрок"),
                new Player("третий игрок"),
                new Player("четвертый игрок"),
                new Player("пятый игрок"));

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        players.forEach(player -> executorService.submit(() -> {
            try {
                player.startBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));
        executorService.shutdown();
    }
}

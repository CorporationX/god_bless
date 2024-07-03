package faang.school.godbless.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        Boss boss = new Boss(3);
        List<Player> players = List.of(
                new Player("Ivan"),
                new Player("Nikita"),
                new Player("Andrei"),
                new Player("Maks"),
                new Player("Vlad")
        );
        players.forEach(player -> service.execute(() -> {
            try {
                player.startBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }));
        service.shutdown();
    }
}

package faang.school.godbless.synchronozation.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Boss boss = new Boss(3);

        List<Player> players = new ArrayList<>(List.of(
                new Player("Vasya"),
                new Player("Petya"),
                new Player("Kolya"),
                new Player("Masha"),
                new Player("Sasha"),
                new Player("Vova"),
                new Player("Dima"),
                new Player("Alex"),
                new Player("Misha")
        ));

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        players.forEach(player -> executorService.execute(() -> player.startBattle(boss)));
        executorService.shutdown();
    }
}

package school.faang.BJS2_63453;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        ExecutorService executor = Executors.newCachedThreadPool();

        List<Player> players = new ArrayList<>(List.of(
                new Player("Ramil", boss),
                new Player("Albert", boss),
                new Player("Vlad", boss),
                new Player("Kamil", boss),
                new Player("Jon", boss),
                new Player("Пак ча юл", boss)
        ));

        players.forEach(player -> {
            executor.submit(player::run);
        });



        executor.shutdown();
    }
}

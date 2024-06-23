package BJS2_12564;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(5);
        List<Player> players = List.of(
                new Player("CalyX", boss),
                new Player("SeregaGlinomes", boss),
                new Player("l0zain", boss),
                new Player("Kirik", boss),
                new Player("NightAtWhat", boss),
                new Player("Ovs", boss)
        );
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        players.forEach(executorService::execute);

        executorService.shutdown();
    }
}

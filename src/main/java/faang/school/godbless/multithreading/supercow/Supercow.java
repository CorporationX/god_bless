package faang.school.godbless.multithreading.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Supercow {
    public static void main(String[] args) throws InterruptedException {
        Boss helicopter = new Boss("Helicopter", 3);
        List<Player> players = List.of(
                new Player("Jack"),
                new Player("Bob"),
                new Player("Tom"),
                new Player("Peter")
        );
        ExecutorService service = Executors.newCachedThreadPool();

        players.forEach(player -> service.execute(() -> player.startBattle(helicopter)));
        service.shutdown();
        Thread.sleep(2000);
        players.get(0).stopBattle(helicopter);
    }
}

package faang.school.godbless.multithreading.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        List<Player> players = List.of(
                new Player("Uriy"),
                new Player("Vaaaleriy"),
                new Player("Grrrigory")
        );

        Boss boss = new Boss(9, 8);
        ExecutorService service = Executors.newFixedThreadPool(3);

        players.forEach(player -> service.execute(() -> player.startBattle(boss)));

        Thread.sleep(3000);

        boss.endBossFight(new Player("thePlayer"));

        if (!service.awaitTermination(6, TimeUnit.SECONDS)) {
            service.shutdownNow();
        }
    }

}

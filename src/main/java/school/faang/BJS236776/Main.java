package school.faang.BJS236776;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MAX_PLAYERS = 2;
    private static final int THREAD_POOL = 3;


    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);

        List<Player> players = List.of(
                new Player("Potter"),
                new Player("Hermione"),
                new Player("Weasley"));

        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL);

        for (Player player : players) {
            service.submit(() -> player.startBattle(boss));
        }

        service.shutdown();

        try {
            if (!service.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Победа за тем чье имя нельзя произносить!");
                service.shutdownNow();
            } else {
                System.out.println("Эта троица снова выжила!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

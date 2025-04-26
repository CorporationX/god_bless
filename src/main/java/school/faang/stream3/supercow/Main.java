package school.faang.stream3.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            playerList.add(new Player("Player" + i));
        }

        Boss boss = new Boss(5);

        ExecutorService executor = Executors.newCachedThreadPool();
        for (Player player : playerList) {
            executor.execute(player.doBattle(boss));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

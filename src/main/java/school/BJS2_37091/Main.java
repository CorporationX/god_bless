package school.BJS2_37091;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(5);

        Game game = new Game(latch);

        Player player1 = new Player("Рома",10,0);
        Player player2 = new Player("Костя",10,0);
        Player player3 = new Player("Вика",10,0);
        Player player4 = new Player("Денис",10,0);
        Player player5 = new Player("Миша",10,0);
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (Player player : players) {
            executorService.scheduleAtFixedRate(() -> game.update(player), 0, 5, TimeUnit.SECONDS);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

}

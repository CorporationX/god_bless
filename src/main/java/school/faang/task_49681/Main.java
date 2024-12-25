package school.faang.task_49681;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int DELAY = 3000;

    public static void main(String[] args) {
        Player[] players = new Player[] {new Player("John"), new Player("Mike"),
                                         new Player("Alex"), new Player("Jason")};

        Boss boss = new Boss(2);

        ExecutorService service = Executors.newFixedThreadPool(players.length);
        for (var player : players) {
            service.submit(() -> player.startBattle(boss));
        }

        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            log.warn("Main thread was interrupted", e);
        }

        //Пробуем выход одного игрока
        Iterator<Player> iterator = boss.getPlayers().iterator();
        if (iterator.hasNext()) {
            Player player = iterator.next();
            player.finishBattle(boss);
        }

        service.shutdownNow();
    }
}

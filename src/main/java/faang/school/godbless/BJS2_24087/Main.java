package faang.school.godbless.BJS2_24087;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Player> players = List.of(new Player("Mark"), new Player("Gosha"), new Player("Eva"));
        Boss boss = new Boss(10, 9);
        ExecutorService service = Executors.newFixedThreadPool(3);

        players.forEach(player -> service.execute(() -> player.startBattle(boss)));

        Thread.sleep(3000);
        boss.endBossFight(new Player("nagibator2002"));
    }
}

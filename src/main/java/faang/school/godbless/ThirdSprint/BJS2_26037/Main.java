package faang.school.godbless.ThirdSprint.BJS2_26037;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static Boss boss = new Boss();

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        List<Player> playerList = new ArrayList<>();
        Player max = new Player("Max");
        Player tom = new Player("tom");
        Player steve = new Player("steve");
        Player mary = new Player("mary");

        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(() -> max.startBattle(boss));
        service.execute(() -> tom.startBattle(boss));
        service.execute(() -> mary.startBattle(boss));
        service.execute(() -> steve.startBattle(boss));

        service.shutdown();
    }
}

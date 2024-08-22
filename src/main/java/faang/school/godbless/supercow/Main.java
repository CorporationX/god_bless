package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("p1");
        Player p2 = new Player("p2");

        Boss boss = new Boss(2, new ArrayList<>(
                List.of(p1, p2)
        ));


        ExecutorService service = Executors.newFixedThreadPool(2);


        Player p3 = new Player("p3");
        Player p4 = new Player("p4");

        service.execute(() -> p3.startBattle(boss));
        service.execute(() -> p4.startBattle(boss));

        boss.leaveBattle(p1);
        boss.leaveBattle(p2);

        service.shutdown();
    }
}

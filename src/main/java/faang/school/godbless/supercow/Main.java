package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");

        Boss boss = new Boss(2, new ArrayList<>(
                List.of(player1, player2)
        ));
        
        ExecutorService service = Executors.newFixedThreadPool(2);
        
        Player player3 = new Player("player3");
        Player player4 = new Player("player4");

        service.execute(() -> player3.startBattle(boss));
        service.execute(() -> player4.startBattle(boss));

        boss.leaveBattle(player1);
        boss.leaveBattle(player2);

        service.shutdown();
    }
}

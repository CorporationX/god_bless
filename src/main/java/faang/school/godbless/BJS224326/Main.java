package faang.school.godbless.BJS224326;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");
        Player player4 = new Player("player4");
        Player player5 = new Player("player5");
        Player player6 = new Player("player6");
        Boss boss  = new Boss(3);

        List<Player> list = List.of(
                player1,
                player2,
                player3,
                player4,
                player5,
                player6
        );

        ExecutorService executorService = Executors.newFixedThreadPool(6);
        list.forEach(play->executorService.execute(()->boss.joinBattle(play)));
        executorService.shutdown();
    }
}

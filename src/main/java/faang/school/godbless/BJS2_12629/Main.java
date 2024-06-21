package faang.school.godbless.BJS2_12629;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Boss boss = new Boss(3);
        List<Player> players = List.of(
                new Player("firstPlayer"),
                new Player("secondPlayer"),
                new Player("thirdPlayer"),
                new Player("forthPlayer"));

        players.forEach(player -> executorService.execute(() ->
                player.startBattle(boss)));
        executorService.shutdown();
    }
}

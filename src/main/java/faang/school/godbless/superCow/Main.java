package faang.school.godbless.superCow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        boss.getPlayerList().add(new Player("first"));
        boss.getPlayerList().add(new Player("second"));
        boss.getPlayerList().add(new Player("third"));
        boss.setCurrentPlayers(3);

        Player player4 = new Player("fourth");
        Player player5 = new Player("fifth");
        Player player6 = new Player("sixth");
        List<Player> playersForJoin = List.of(player4, player6, player5);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executorForLeaving = Executors.newSingleThreadExecutor();

        for (Player player : playersForJoin){
            executor.submit(() -> player.startBattle(boss));
        }
        for (Player player : boss.getPlayerList()){
            executorForLeaving.submit(() -> player.leaveBattle(boss));
        }

        executor.shutdown();
        executorForLeaving.shutdown();
    }
}

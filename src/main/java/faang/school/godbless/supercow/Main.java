package faang.school.godbless.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private final static int THREAD_NUM = 4;
    private final static int MAX_PLAYERS = 3;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);

        ExecutorService lobby = Executors.newFixedThreadPool(THREAD_NUM);

        List<Player> playerList = getPlayers();

        playerList.forEach(
                player -> lobby.execute(
                        () -> player.startBattle(boss)
                )
        );

        lobby.shutdown();
    }

    private static List<Player> getPlayers() {
        return List.of(
                new Player("FirstPlayer"),
                new Player("SecondPlayer"),
                new Player("ThirdPlayer"),
                new Player("FourthPlayer")
        );
    }
}

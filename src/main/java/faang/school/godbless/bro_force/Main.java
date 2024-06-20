package faang.school.godbless.bro_force;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_NUM = 5;
    private static final int TIME_LIMIT = 2;


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

        Game game = new Game();
        List<Player> playerList = getPlayerList(game);

        playerList.forEach(executorService::execute);

        try {
            executorService.awaitTermination(TIME_LIMIT, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }

    private static List<Player> getPlayerList(Game game) {
        return List.of(
                new Player("FirstPlayer", 3, game),
                new Player("SecondPlayer", 3, game),
                new Player("ThirdPlayer", 3, game),
                new Player("FourthPlayer", 3, game),
                new Player("FifthPlayer", 3, game)
        );
    }
}

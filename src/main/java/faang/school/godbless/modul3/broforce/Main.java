package faang.school.godbless.modul3.broforce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int N_TREADS = 4;
    private static final int START_LIVES = 3;
    private static final int TOTAL_ROUNDS = (N_TREADS * START_LIVES) - 1;

    public static void main(String[] args) {
        Game game = new Game();

        Player player1 = new Player("Ivan", 0, START_LIVES, true);
        game.addPlayer(player1);

        Player player2 = new Player("Petr", 0, START_LIVES, true);
        game.addPlayer(player2);

        Player player3 = new Player("Vadim", 0, START_LIVES, true);
        game.addPlayer(player3);

        Player player4 = new Player("Anna", 0, START_LIVES, true);
        game.addPlayer(player4);

        ExecutorService executorService = Executors.newFixedThreadPool(N_TREADS);

        int round = 0;
        while (round < TOTAL_ROUNDS) {
            executorService.execute(() -> {
                if (game.getPlayers().size() > 1) {
                    game.update();
                }
            });
            ++round;
        }

        executorService.shutdown();

        try {
            while (!executorService.awaitTermination(30, TimeUnit.SECONDS)) ;
        } catch (InterruptedException ex) {
            throw new RuntimeException();
        }

        System.out.println("\n" + "WINNER:");
        game.getPlayers().forEach(player -> System.out.println(player.getName()));
    }
}

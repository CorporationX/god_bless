package faang.school.godbless.broForce;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Game player1 = new Game(5);
        Game player2 = new Game(10);

        executor.execute(() -> runGame(player1, "Player 1", player2));
        executor.execute(() -> runGame(player2, "Player 2", player1));

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("Player 1: Lives - " + player1.getLives() + ", Score - " + player1.getScore());
        System.out.println("Player 2: Lives - " + player2.getLives() + ", Score - " + player2.getScore());

        System.out.println("Final Score:");
        System.out.println("Player 1: " + player1.getScore());
        System.out.println("Player 2: " + player2.getScore());

        System.out.println("General Score of the game: " + (player1.getScore() + player2.getScore()));
    }

    private static void runGame(Game game, String playerName, Game opponent) {
        if (opponent.getLives() > 0) {
            while (true) {
                synchronized (game) {
                    if (game.getLives() <= 0) {
                        opponent.setLives(0);
                        break;
                    }

                    game.update();
                    System.out.println(playerName + ": Lives - " + game.getLives() + ", Score - " + game.getScore());
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

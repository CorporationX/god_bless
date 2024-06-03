package BJS2_6017;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Player player1 = new Player("1 Игрок", 100);
        Player player2 = new Player("2 Игрок", 100);
        Player player3 = new Player("3 Игрок", 100);

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);

        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 3; i++) {
            service.execute(() -> {
                while (game.update()) ;
            });
        }
        service.shutdown();

        try {
            while (!service.awaitTermination(30, TimeUnit.SECONDS)) ;
            game.gameOver();
        } catch (InterruptedException ex) {
            throw new RuntimeException();
        }
    }
}

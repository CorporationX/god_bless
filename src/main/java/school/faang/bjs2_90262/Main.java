package school.faang.bjs2_90262;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Player playerOne = new Player("PlayerOne");
        Player playerTwo = new Player("PlayerTwo");
        Player playerThree = new Player("PlayerThree");
        Player playerFour = new Player("PlayerFour");
        Player playerFive = new Player("PlayerFive");
        Player playerSix = new Player("PlayerSix");
        Player playerSeven = new Player("PlayerSeven");
        Player playerEight = new Player("PlayerEight");
        List<Player> players = List.of(
                playerOne, playerTwo, playerThree,
                playerFour, playerFive, playerSix,
                playerSeven, playerEight);

        Boss boss = new Boss();
        ExecutorService executor = Executors.newFixedThreadPool(8);
        for (Player player : players) {
            executor.execute(() -> player.doBattle(boss));
        }
        executor.shutdown();
    }
}

package school.faang.bjs2_61605;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();

        List<Player> players = Arrays.asList(
            new Player("Garry"),
            new Player("John"),
            new Player("Jane")
        );

        for (Player player : players) {
            Thread thread = new Thread(() -> player.doBattle(boss));
            thread.start();
        }
    }

}

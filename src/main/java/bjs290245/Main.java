package bjs290245;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        players.add(new Player("Alice"));
        players.add(new Player("Bob"));
        players.add(new Player("Charlie"));
        players.add(new Player("Diana"));
        players.add(new Player("Eve"));

        Boss boss = new Boss(5);

        for (Player player : players) {
            new Thread(() ->
                    player.doBattle(boss)).start();
        }
    }
}

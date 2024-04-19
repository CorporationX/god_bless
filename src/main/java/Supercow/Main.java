package Supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        List<Player> players = addPlayers();

        for (Player player : players) {
            new Thread(() -> player.startBattle(boss)).start();
        }
    }

    private static List<Player> addPlayers() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            players.add(new Player("player - " + (i + 1)));
        }
        return players;
    }
}

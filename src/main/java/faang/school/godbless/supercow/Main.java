package faang.school.godbless.supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(3);
        List<Player> players = initialize();

        for (Player player : players) {
            new Thread(() -> player.startBattle(boss)).start();
        }
    }

    private static List<Player> initialize() {
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            players.add(new Player("player_" + (i + 1)));
        }
        return players;
    }
}

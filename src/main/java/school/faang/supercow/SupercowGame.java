package school.faang.supercow;

import java.util.ArrayList;
import java.util.List;

public class SupercowGame {

    public static void main(String[] args) {
        Boss boss = new Boss(3);

        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            players.add(new Player("Игрок " + i));
        }

        for (Player player : players) {
            new Thread(() -> player.doBattle(boss)).start();
        }
    }
}


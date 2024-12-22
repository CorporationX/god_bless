package school.faang.sprint_1.task_supercowbjs2n49687;

import java.util.ArrayList;
import java.util.List;

public class SupercowMain {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        List<Player> players = new ArrayList<>(List.of(
                new Player("Player1"),
                new Player("Player2"),
                new Player("Player3"),
                new Player("Player4"),
                new Player("Player5")
        ));

        for (Player player : players) {
            player.startBattle(boss);
        }
    }
}


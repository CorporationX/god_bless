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
                new Player("Player5"),
                new Player("Player6"),
                new Player("Player7")
        ));

        for (Player player : players) {
            Thread thread = new Thread(() -> player.startBattle(boss));
            thread.start();
            Thread threadToLeave = new Thread(() -> player.leaveBattle(boss));
            threadToLeave.start();
        }
    }
}


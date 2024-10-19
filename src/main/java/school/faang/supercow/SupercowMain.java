package school.faang.supercow;

import java.util.List;

public class SupercowMain {
    public static void main(String[] args) {
        Boss boss = new Boss(3); // Босс может одновременно сражаться с 3 игроками

        List<Player> players = List.of(
                new Player("Игрок 1", boss),
                new Player("Игрок 2", boss),
                new Player("Игрок 3", boss),
                new Player("Игрок 4", boss),
                new Player("Игрок 5", boss)
        );

        for (Player player : players) {
            new Thread(player).start();
        }
    }
}

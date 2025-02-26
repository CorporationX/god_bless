package school.faang.task61643;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(5);
        List<Player> players = List.of(
                new Player("A"),
                new Player("B"),
                new Player("C"),
                new Player("D"),
                new Player("E"),
                new Player("F"),
                new Player("G"),
                new Player("H")
                );
        players.forEach(player -> new Thread(() -> player.doBattle(boss, player)).start());
    }
}

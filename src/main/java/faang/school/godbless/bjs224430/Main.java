package faang.school.godbless.bjs224430;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss();
        List<Player> players = List.of(
                new Player("player1"),
                new Player("player2"),
                new Player("player3"),
                new Player("player4"),
                new Player("player5"),
                new Player("player6"),
                new Player("player7"),
                new Player("player8"),
                new Player("player9"),
                new Player("player10")
        );

        for (var player : players) {
            new Thread(() -> player.startBattle(boss)).start();
        }
    }
}

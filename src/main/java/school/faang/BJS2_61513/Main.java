package school.faang.BJS2_61513;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);

        Player player1 = new Player("Игрок 1");
        Player player2 = new Player("Игрок 2");
        Player player3 = new Player("Игрок 3");
        Player player4 = new Player("Игрок 4");

        List<Player> players = List.of(player1, player2, player3, player4);

        for (Player player : players) {
            Thread thread = new Thread(() -> {
                try {
                    player.doBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
        }
    }
}
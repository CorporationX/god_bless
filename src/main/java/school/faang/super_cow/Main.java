package school.faang.super_cow;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final Boss boss = new Boss(2); // Босс с максимум 2 игроками одновременно

        List<Player> players = new ArrayList<>();
        // Создаем игроков
        Player player1 = new Player("Игрок 1");
        Player player2 = new Player("Игрок 2");
        Player player3 = new Player("Игрок 3");
        Player player4 = new Player("Игрок 4");

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        for (Player player : players) {
            Thread thread = new Thread(() -> player.doBattle(boss));
            thread.start();
            thread.join();
        }

    }
}

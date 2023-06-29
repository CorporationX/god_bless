package faang.school.godbless.Supercow;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        List<Player> players = Arrays.asList(
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4")
        );
        for (var player : players) {
            var thread = new Thread(() -> {
                try {
                    player.startBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
        }
    }
}

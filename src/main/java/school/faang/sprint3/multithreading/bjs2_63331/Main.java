package school.faang.sprint3.multithreading.bjs2_63331;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = List.of(
                new Player("Max"),
                new Player("Ray"),
                new Player("Lena"),
                new Player("Vic"),
                new Player("Dan")
        );
        Boss boss = new Boss(3);
        List<Thread> threads = new ArrayList<>();
        for (Player player : players) {
            Thread thread = new Thread(() -> player.doBattle(boss));
            thread.start();
        }
    }
}

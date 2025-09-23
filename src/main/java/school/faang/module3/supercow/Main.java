package school.faang.module3.supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(3);
        List<Player> players = List.of(
                new Player("Paladin"),
                new Player("Priest"),
                new Player("Warrior"),
                new Player("Barbarian"),
                new Player("Archer"),
                new Player("Mage")

        );

        List<Thread> threads = new ArrayList<>();

        players.forEach(p -> {
            Thread thread = new Thread(() -> p.doBattle(boss));
            thread.start();
            threads.add(thread);
        });

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}

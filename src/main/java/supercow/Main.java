package supercow;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3);
        List<Player> players = new ArrayList<>(
            List.of(
                new Player("Player1"),
                new Player("Player2"),
                new Player("Player3"),
                new Player("Player4"),
                new Player("Player5"),
                new Player("Player6")
            )
        );

        List<Thread> threads = players.stream()
            .map(player -> new Thread(() -> player.startBattle(boss)))
            .toList();

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("Битва с босом окончена");
    }
}

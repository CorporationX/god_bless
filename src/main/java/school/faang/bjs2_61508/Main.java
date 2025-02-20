package school.faang.bjs2_61508;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        List<Player> players = List.of(
                new Player("Player_1"),
                new Player("Player_2"),
                new Player("Player_3"),
                new Player("Player_4"),
                new Player("Player_5"),
                new Player("Player_6"),
                new Player("Player_7"),
                new Player("Player_8")
        );

        List<Thread> threads = players.stream()
                .map(player -> new Thread(() -> player.doBattle(boss)))
                .toList();
        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("Main thread was interrupted!");
            }
        });
        log.info("All battles are finished.");

    }
}

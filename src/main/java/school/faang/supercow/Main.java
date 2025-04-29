package school.faang.supercow;

import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Boss boss = new Boss(2);

        List<Player> playerList = List.of(
                new Player("Jon"),
                new Player("ben"),
                new Player("stiv"),
                new Player("stas"),
                new Player("bob"),
                new Player("peek"));

        playerList.parallelStream()
                .map(player -> new Thread(() -> player.doBattle(boss)))
                .peek(Thread::start)
                .forEach(thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                });
    }
}

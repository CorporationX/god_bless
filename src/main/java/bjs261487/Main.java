package bjs261487;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Boss boss = new Boss(0);
        List<Player> players = List.of(new Player("First player"), new Player("Second player"),
                new Player("Third player"), new Player("Fourth player"), new Player("Fifth player"),
                new Player("Sixth player"), new Player("Seventh player"),
                new Player("Eighth player"));
        List<Thread> threads = new ArrayList<>();

        players.forEach(player -> {
            Thread thread = new Thread(() -> {
                try {
                    player.doBattle(boss);
                } catch (InterruptedException e) {
                    LOGGER.error("Thread {} started, but not completed due to InterruptedException",
                            Thread.currentThread().getName());
                    throw new RuntimeException(e);
                }
            });
            threads.add(thread);
        });
        threads.forEach(Thread::start);
    }
}

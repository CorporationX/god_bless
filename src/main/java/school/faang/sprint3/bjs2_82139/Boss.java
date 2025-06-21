package school.faang.sprint3.bjs2_82139;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Data
public class Boss {
    private static final int THREAD_BATCH = 5;
    private final Object lock = new Object();

    private final int maxPlayers;
    private List<Player> players = new ArrayList<>();

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (players.contains(player)) {
                System.out.printf("Игрок %s уже в битве с боссом\n", player.getName());
            } else {
                while (players.size() >= maxPlayers) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                }
                players.add(player);
                System.out.printf("Игрок %s присоединился к битве с боссом\n", player.getName());
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (!players.contains(player)) {
                System.out.printf("Игрок %s уже покинул бой\n", player.getName());
            } else {
                System.out.printf("Игрок %s покинул бой\n", player.getName());
                players.remove(player);
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Boss boss = new Boss(4);
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_BATCH);
        List<Player> players = List.of(
                new Player("Player 1"), new Player("Player 2"),
                new Player("Player 3"), new Player("Player 4"),
                new Player("Player 5"), new Player("Player 6"),
                new Player("Player 7"), new Player("Player 8")
        );
        players.forEach(player -> player.doBattle(boss));

        executor.shutdown();
        try {
            if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}

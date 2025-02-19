package school.faang.sprint3.task_BJS2_61500;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class Boss {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(4);
    private static final Boss BOSS = new Boss(2);

    public static void main(String[] args) {
        IntStream.range(1, 11)
                .forEach(num -> {
                    Player player = new Player("Player" + num);
                    EXECUTOR.submit(() -> player.doBattle(BOSS));
                });
        EXECUTOR.shutdown();
    }

    private final int maxPlayers;
    private volatile List<Player> players = new ArrayList<>();

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (players.size() == maxPlayers) {
            this.wait();
        }
        players.add(player);
    }

    public synchronized void leaveBattle(Player player) {
        if (!players.isEmpty()) {
            players.remove(player);
        }
        this.notify();
    }
}

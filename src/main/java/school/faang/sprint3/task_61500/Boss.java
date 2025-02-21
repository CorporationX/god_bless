package school.faang.sprint3.task_61500;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(4);
    private static final Boss BOSS = new Boss(2);
    private static final String logForm = "Игрок {} {} бой";
    private static final String wait = "ждет";
    private static final String join = "идет в";
    private static final String leave = "покидает";

    public static void main(String[] args) {
        IntStream.range(1, 11)
                .forEach(num -> EXECUTOR.submit(() -> new Player("Player" + num).doBattle(BOSS)));
        EXECUTOR.shutdown();
    }

    private final int maxPlayers;
    private final List<Player> players = new ArrayList<>();

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (players.size() == maxPlayers) {
            log.info(logForm, player, wait);
            this.wait();
        }
        log.info(logForm, player, join);
        players.add(player);
    }

    public synchronized void leaveBattle(Player player) {
        if (!players.isEmpty()) {
            log.info(logForm, player, leave);
            players.remove(player);
        }
        this.notify();
    }
}

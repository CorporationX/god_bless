package school.faang.bro_force;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Проект: god_bless
 * Класс GameLoop
 * Автор: Vital
 */

public class GameLoop {
    private final Game game;
    private final List<Player> players;
    private final ScheduledExecutorService scheduler;

    public GameLoop(Game game, List<Player> players) {
        this.game = game;
        this.players = players;
        this.scheduler = Executors.newScheduledThreadPool(players.size());
    }

    public void start() {
        Runnable tick = () -> {
            if (!game.isGameOver()) {
                players.forEach(player ->
                        scheduler.submit(() -> game.update(player.earnedPoints(), player.lostLife()))
                );
            } else {
                scheduler.shutdown();
                System.out.println("Все потоки остановлены.");
            }
        };

        //Запускаем игровой тик каждые 100 мс
        scheduler.scheduleAtFixedRate(tick, 0, 100, TimeUnit.MILLISECONDS);
    }
}
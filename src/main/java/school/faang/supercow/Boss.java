package school.faang.supercow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private final Object lock = new Object();
    private final List<Player> battlePlayers = new ArrayList<>();

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (battlePlayers.size() >= maxPlayers) {
                try {
                    log.info("Boss is busy, player {} is waiting", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException("Interrupted while waiting for the boss.", e);
                }
            }
            battlePlayers.add(player);
            log.info("Player {} has joined the battle", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            battlePlayers.remove(player);
            log.info("Player {} has finished the battle, another player can join", player.getName());
            lock.notifyAll();
        }
    }
}
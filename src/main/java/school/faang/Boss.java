package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Getter
public class Boss {
    private final int maxPlayers = 3;
    private final Set<Player> currentPlayers = new HashSet<>();

    private final Object lock = new Object();


    public void joinBattle(Player player) {
        synchronized (lock) {
            while (true) {
                if (currentPlayers.size() < maxPlayers) {
                    currentPlayers.add(player);
                    log.info(String.format("%s вступает в бой. " +
                            "Текущее количетсво игроков %d/%d", player.getName(), currentPlayers.size(), maxPlayers));
                    break;
                } else {
                    try {
                        log.info("Слоты сейчас заполнены, подождите... ");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        log.warn("Поток был прерван");
                    }
                }
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers.remove(player)) {
                log.info(String.format(" %s покинул бой. " +
                        "Текущее количество игроков %d/%d", player.getName(), currentPlayers.size(), maxPlayers));
                lock.notify();
            } else {
                log.info(String.format("%s не находится в бою.", player.getName()));
            }
        }
    }
}

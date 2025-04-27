package school.faang.supercow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();
    private final List<Player> battlePlayers;

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("Босс занят, игрок {} ожидает", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            battlePlayers.add(player);
            log.info("Игрок {} присоединился к битве", player.getName());
            currentPlayers++;
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            battlePlayers.remove(player);
            log.info("Игрок {} закончил битву, другой игрок может вступить в битву", player.getName());
            currentPlayers--;
            lock.notifyAll();
        }
    }
}
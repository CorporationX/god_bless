package BJS261504;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Getter
public class Boss {
    private final Integer maxPlayers;
    private Integer currentPlayers;
    private final Object lock = new Object();
    private final List<Player> playersInBattle = Collections.synchronizedList(new ArrayList<>());

    public Boss(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        if (player != null) {
            synchronized (lock) {
                if (currentPlayers < maxPlayers) {
                    log.info("{} joined the battle!", player.getName());
                    playersInBattle.add(player);
                    currentPlayers++;
                } else {
                    try {
                        log.info("{} in queue!", player.getName());
                        log.info((" players in battle: %s"
                                .formatted(playersInBattle.stream()
                                .map(Player::getName).toList())));
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }

                }
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (player != null) {
                log.info("{} left the battle!", player.getName());
                playersInBattle.remove(player);
                currentPlayers--;
                lock.notify();
            }
        }
    }

}

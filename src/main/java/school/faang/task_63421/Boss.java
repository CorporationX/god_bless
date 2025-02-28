package school.faang.task_63421;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("{} был прерван во время ожидания", player.getName(), e);
            }
        }
        currentPlayers++;
        log.info("{} вступил в бой. Всего игроков: {}", player.getName(), currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayers > 0) {
            currentPlayers--;
            log.info("{} покинул бой. Осталось игроков {}", player.getName(), currentPlayers);
            notify();
        }
    }

}

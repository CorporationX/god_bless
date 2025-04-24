package school.faang.supercow;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        log.debug("joinBattle() is executing by Thread {}", Thread.currentThread().getName());
        while (currentPlayers >= maxPlayers) {
            log.debug("maxPlayers reached, calling wait()");
            this.wait(3000);
        }
        currentPlayers++;
        log.debug("player {} joined a battle, currentPlayers {}", player.getName(), currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        log.debug("leaveBattle() is executing by Thread {}", Thread.currentThread().getName());
        currentPlayers--;
        log.debug("player {} has left the battle, currentPlayers {}", player.getName(), currentPlayers);
        this.notifyAll();
    }
}

package school.faang.bjs2_90410;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            log.info("Игрок {} ожидает присоединения к бою", player.getName());
            this.wait();
        }
        currentPlayers++;
        log.info("Игрок {} присоединился к бою", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("Игрок {} вышел из боя", player.getName());
        this.notifyAll();
    }
}

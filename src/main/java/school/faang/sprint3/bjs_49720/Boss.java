package school.faang.sprint3.bjs_49720;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Getter
@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (maxPlayers <= currentPlayers) {
            this.wait();
        }
        currentPlayers++;
        log.info("Игрок {} добавлен в сражение", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("Игрок {} закончил сражение", player.getName());
        this.notifyAll();
    }
}

package school.faang.syncs.supercow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {

    private int playersInBattle = 0;
    private final int maxPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (playersInBattle == maxPlayers) {
            log.info("Lobby is full, waiting for someone to leave...");
            wait();
        }
        playersInBattle++;
        log.info("{} is joining boss battle", player);
    }

    public synchronized void leaveBattle(Player player) {
        playersInBattle--;
        log.info("{} left battle", player);
        notify();
    }
}

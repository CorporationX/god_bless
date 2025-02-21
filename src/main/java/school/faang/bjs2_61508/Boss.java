package school.faang.bjs2_61508;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                log.info("{} is waiting to join the battle...", player.getName());
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        currentPlayers++;
        log.info("{} joined the battle! Current players: {}/{}", player.getName(), currentPlayers, maxPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info("{} left the battle. Current players: {}/{}", player.getName(), currentPlayers, maxPlayers);
        notifyAll();
    }
}

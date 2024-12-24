package school.faang.sprint3.bjs_49610;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
    }

    public synchronized void joinGame(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            log.info("Player {} is waiting for slot...", player.playerName());
            wait();
        }
        currentPlayers++;
        log.info("Player {} joined the game", player.playerName());
    }

    public synchronized void gameOver(Player player) {
        log.info("Game over for player {}", player.playerName());
        currentPlayers--;
        notify();
    }
}

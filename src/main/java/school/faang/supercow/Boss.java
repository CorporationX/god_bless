package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Boss {
    private static final int MAX_PLAYERS = 2;

    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        Objects.requireNonNull(player, "Player doesn't exist");
        if (currentPlayers == MAX_PLAYERS) {
            this.wait();
        }
        log.info("Player {} joined to battle", player.getName());
        currentPlayers++;
        printCountPlayers();
    }

    public synchronized void leaveBattle(Player player) {
        log.info("Player {} left the battle", player.getName());
        currentPlayers--;
        printCountPlayers();
        this.notify();
    }

    private void printCountPlayers() {
        log.info("Current players: {}/{}", currentPlayers, MAX_PLAYERS);
    }
}

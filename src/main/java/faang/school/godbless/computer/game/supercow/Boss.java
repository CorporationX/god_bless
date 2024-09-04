package faang.school.godbless.computer.game.supercow;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers == maxPlayers) {
            try {
                System.out.printf("Player %s waiting for empty slot\n", player.getPlayerName());
                this.wait();
            } catch (InterruptedException e) {
                log.error(String.format("Interrupted while player %s was waiting for empty slot", player.getPlayerName()));
                Thread.currentThread().interrupt();
            }
        }
        currentPlayers++;
        System.out.printf("Player %s joined the battle. Number of current players: %d\n", player.getPlayerName(), currentPlayers);
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.printf("Player %s left the battle. Number of current players: %d\n", player.getPlayerName(), currentPlayers);
        this.notify();
    }
}

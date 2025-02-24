package supercow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.printf("Player %s is waiting to join the battle.%n", player.getName());
                wait();
            } catch (InterruptedException e) {
                log.error("Player {} was interrupted while waiting to join the battle.", player.getName(), e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.printf("Player %s has joined the battle.%n", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.printf("Player %s has left the battle.%n", player.getName());
        notify();
    }
}

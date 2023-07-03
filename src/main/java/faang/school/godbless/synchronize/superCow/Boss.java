package faang.school.godbless.synchronize.superCow;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Boss {
    private int currentPlayers;
    private final int maxPlayers;

    public void joinBattle(Player player) {
        synchronized (this) {
            if (currentPlayers < maxPlayers) {
                currentPlayers++;
                System.out.println(player.getName() + " has joined the battle");
            } else {
                System.out.println("Waiting for players to cansel battle...");
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void finishBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " has finished the battle");
        notify();
    }
}

package faang.school.godbless.BJS2_24179;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        while (currentPlayers == maxPlayers) {
            System.out.println(player.getName() + " waiting for his turn");
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.println(player.getName() + " joined the battle");
    }

    public void exitBattle(Player player) {
        synchronized (this) {
            currentPlayers--;
            System.out.println(player.getName() + " completed the battle!");
            this.notify();
        }
    }
}

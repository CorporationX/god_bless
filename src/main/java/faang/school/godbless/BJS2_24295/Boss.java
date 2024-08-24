package faang.school.godbless.BJS2_24295;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Boss {

    private final int maxPlayers;
    private int currentPlayers = 0;

    public void joinBattle(Player player) {
        synchronized (this) {
            while (currentPlayers >= maxPlayers) {
                try {
                    System.out.println("Player " + player.getName() + " is waiting");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            player.setJoined(true);
            System.out.println("Player " + player.getName() + " joined the battle!");
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println("Player " + player.getName() + " left the battle!");
        notify();
    }
}

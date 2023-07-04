package Multithreading.bc2868;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.println("I'm here");
            wait();
        }
        currentPlayers++;
        System.out.println(player.name() + " add to battle " + currentPlayers);
    }

    public synchronized void endBattle(Player player) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(player.name() + " finished battle");
        currentPlayers--;
        notify();
    }
}

package Multithreading.bc2868;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public void joinBattle(Player player) throws InterruptedException {
        if (currentPlayers <= maxPlayers) {
            currentPlayers++;
            System.out.println(player.name() + " add to battle " + currentPlayers);
        } else {
            System.out.println("I'm here");
            player.wait();
        }
    }

    public void endBattle(Player player) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(player.name() + " finished battle");
        currentPlayers--;
        player.notify();
    }
}

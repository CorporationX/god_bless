package faang.school.godbless.Sprint_4.Multithreading_Synchronization.Supercow;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (currentPlayers == maxPlayers) {
            wait();
        }
        currentPlayers++;
        System.out.printf("Player - %s joined\n", player.getName());
    }

    public synchronized void leaveBattle(Player player) throws InterruptedException {
        currentPlayers--;
        System.out.printf("Player - %s left\n", player.getName());
        notify();
    }
}

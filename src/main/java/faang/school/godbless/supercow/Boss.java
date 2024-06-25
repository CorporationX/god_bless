package faang.school.godbless.supercow;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (currentPlayers == maxPlayers) {
            wait();
        }
        currentPlayers++;
        System.out.println("Player " + player.getName() + " join battle");
    }

    public synchronized void finishBattle(Player player) throws InterruptedException {
        currentPlayers--;
        notify();
        System.out.println("Player " + player.getName() + " finish battle");
    }
}

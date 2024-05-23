package faang.school.godbless.multithreading_synchronization.BJS2_6506;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            System.out.println(player.getName() + " is waiting to join the battle.");
            wait();
        }

        currentPlayers++;
        System.out.println(player.getName() + " has joined the battle.");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " has left the battle.");
        notify();
    }
}

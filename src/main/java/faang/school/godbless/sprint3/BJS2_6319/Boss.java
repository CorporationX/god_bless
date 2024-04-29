package faang.school.godbless.sprint3.BJS2_6319;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;

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

package school.faang.sprint_3.task_49619;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Boss {
    private static final int WAIT_DELAY = 1000;

    private final int maxPlayers;
    private int currentPlayers = 0;

    public synchronized void joinBattle(Player player) {
        while (currentPlayers >= maxPlayers) {
            try {
                System.out.println(player.name() + " is waiting for battle");
                wait(WAIT_DELAY);
            } catch (InterruptedException e) {
                System.out.println("waiting for battle interrupted");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Player " + player.name() + " joined the battle");
        currentPlayers++;
    }

    public synchronized void leaveBattle(Player player) {
        if (currentPlayers > 0) {
            currentPlayers--;
            System.out.println("Player " + player.name() + " left the battle");
            notify();
        }
    }
}

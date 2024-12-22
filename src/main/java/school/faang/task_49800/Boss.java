package school.faang.task_49800;

import lombok.Getter;

@Getter
public class Boss {
    static final int MAX_PLAYERS = 2;
    private int currentPlayers;

    public synchronized void joinBattle(Player player) {
        if (currentPlayers < MAX_PLAYERS) {
            System.out.println("Player " + player.getName() + " CurrentPlayers Befor start " + currentPlayers);
            currentPlayers++;
            System.out.println("Player " + player.getName() + " CurrentPlayers After start " + currentPlayers);
        } else {
            System.out.println("Player " + player.getName() + " Wait Befor start, currentPlayers = " + currentPlayers);
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Exception " + e);
            }

            currentPlayers++;
            System.out.println("Player " + player.getName() + " Start after wait,  currentPlayers = " + currentPlayers);
        }
    }

    public synchronized void finishBattle(Player player) {
        currentPlayers = currentPlayers - 1;
        System.out.println("Player " + player.getName() + " is finish");
        notify();
    }
}

package derschrank.sprint03.task07.bjstwo_49649;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    private final int maxPlayers;
    private final List<Player> currentPlayers;


    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = new ArrayList<>();
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayers.size() >= maxPlayers) {
            System.out.println(". " + player + " waits for a slot to the fight with the Boss");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("joinBattle was interrupted: " + e);
            }
        }
        currentPlayers.add(player);
        System.out.println("+ " + player + " was joined to the fight with the Boss");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers.remove(player);
        System.out.println("- " + player + " was left from the fight with the Boss");
        notify();
    }
}

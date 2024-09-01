package faang.school.godbless.multithreading.supercow;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Boss {

    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers, int currentPlayers) {
        if (currentPlayers > maxPlayers) {
            throw new IllegalArgumentException("too much players fo this boss");
        }

        this.maxPlayers = maxPlayers;
        this.currentPlayers = currentPlayers;
    }

    public synchronized void joinBattle(Player player) {
        try {
            if (this.maxPlayers == currentPlayers) {
                System.out.printf("> %s is waiting to enter the boss fight%n", player.name());

                this.wait();
            }

            System.out.printf("> %s is starting fight!%n", player.name());

            currentPlayers++;
        } catch (InterruptedException e) {
            System.err.println("> thread is interrupted");
        }
    }

    public synchronized void endBossFight(Player player) {
        System.out.printf("> %s has left the fight%n", player.name());

        currentPlayers--;
        this.notify();
    }
}

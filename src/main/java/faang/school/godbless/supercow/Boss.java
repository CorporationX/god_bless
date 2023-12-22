package faang.school.godbless.supercow;

import java.util.Random;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    void joinBattle(Player player) {

        synchronized (this) {
            if (currentPlayers >= maxPlayers) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
        }

        System.out.println(player.getName() + " has started a boss battle!");
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(player.getName() + " has finished a boss battle!");

        synchronized (this) {
            currentPlayers--;
            this.notify();
        }
    }
}

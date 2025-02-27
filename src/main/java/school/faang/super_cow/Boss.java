package school.faang.super_cow;

import static java.lang.Thread.sleep;

public class Boss {

    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        if (currentPlayers >= maxPlayers) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayers++;
        System.out.println("Игрок " + player.getName() + " присоединился к битве");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println("Игрок " + player.getName() + " покинул битву");
        notify();
    }
}

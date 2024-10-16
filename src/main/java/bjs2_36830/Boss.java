package bjs2_36830;

import java.util.Random;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    private Random random;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
        this.random = new Random();
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        if (currentPlayers >= maxPlayers) {
            currentPlayers = maxPlayers;
            wait();
        }
        currentPlayers++;
        System.out.println("Player: " + player.getName() + " starts battle");
        System.out.println("currentPlayers: " + currentPlayers);
    }

    public synchronized void leaveBattle(Player player) throws InterruptedException {
        Thread.sleep(random.nextInt(3) * 500 + 1000);
        currentPlayers--;
        System.out.println("Player: " + player.getName() + " go home");
        System.out.println("currentPlayers: " + currentPlayers);
        notify();
    }
}

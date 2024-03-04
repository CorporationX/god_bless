package faang.school.godbless.supercow;

import java.util.Random;

public class Boss {
    private int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers == maxPlayers) {
                try {
                    System.out.printf("%s is waiting...", player.getName());
                    System.out.println();
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            currentPlayers++;
            System.out.printf("%s joins the battle!", player.getName());
            System.out.println();
        }
    }

    public void fight(Player player) {
        try {
            Thread.sleep(new Random().nextInt(1000, 2500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Battle for %s is over", player.getName());
        System.out.println();
        synchronized (lock) {
            currentPlayers--;
            lock.notify();
        }
    }
}

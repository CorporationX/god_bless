package faang.school.godbless.multithreading.synchronizationPractice.supercow;

import lombok.Getter;

@Getter
public class Boss {
    private final Object lock = new Object();
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (lock) {
            while (maxPlayers <= currentPlayers) {
                wait();
                System.out.println(player.getName() + " waiting free slot..");
            }
            currentPlayers++;
            System.out.println(player.getName() + " joined to battle!");
        }
    }

    public void endBattle(Player player) {
        synchronized (lock) {
            System.out.println(player.getName() + " fenitto la comedia");
            currentPlayers--;
            notifyAll();
        }
    }

}

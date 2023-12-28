package faang.school.godbless.multithreading.synchronizationPractice.supercow;

import lombok.Getter;

@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (maxPlayers <= currentPlayers) {
            wait();
            System.out.println(player.getName() + " waiting free slot..");
        }
        currentPlayers++;
        System.out.println(player.getName() + " joined to battle!");
    }

    public synchronized void endBattle(Player player) {
        System.out.println(player.getName() + " fenitto la comedia");
        currentPlayers--;
        notifyAll();
    }

}

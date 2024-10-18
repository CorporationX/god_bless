package mod1sp3.supercow;

import lombok.Data;

@Data
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            if (currentPlayers < maxPlayers) {
                currentPlayers++;
                System.out.println("Игрок " + player.getName() + " присоединился к битве!");
            } else {
                try {
                    System.out.println("Игрок " + player.getName() + " ждёт своей очереди вступить в битву...");
                    lock.wait();
                    currentPlayers++;
                    System.out.println("Игрок " + player.getName() + " присоединился к битве!");
                } catch (InterruptedException e) {
                    throw new IllegalStateException("Wait method error " + e.getMessage(), e);
                }
            }
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println("Игрок " + player.getName() + " покинул битву!");
            lock.notify();
        }
    }
}

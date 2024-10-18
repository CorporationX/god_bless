package school.faang.Multithreading.sprint_3.Supercow;

import lombok.Getter;

@Getter
public class Boss {
    private final Object lock = new Object();
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    System.out.println("Игрок " + player.getName() + " не может присоединиться, нет свободного места");
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Операция была прервана" + e.getMessage());
                    e.printStackTrace();
                    Thread.currentThread().interrupt();;
                }
            }

        }
        currentPlayers++;
        System.out.println("Игрок " + player.getName() + currentPlayers +" добавлен в сражение");
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.println("Игрок " + player.getName() + currentPlayers+ " закончил сражение \t Место освободилось");
            lock.notify();
        }
    }

}

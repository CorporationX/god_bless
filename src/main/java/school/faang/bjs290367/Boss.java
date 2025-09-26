package school.faang.bjs290367;

import lombok.Getter;

public class Boss {
    @Getter
    private final int maxPlayers; // Максимальное количество игроков
    private int currentPlayers; // Текущее количество игроков в бою
    private final Object lock = new Object(); // Объект для синхронизации

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    System.out.println(player.getName() + " is waiting to join the battle.");
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println(player.getName() + " was interrupted while waiting to join the battle: "
                        + e.getMessage());
                    throw new RuntimeException(e);
                }
            }
            System.out.println(player.getName() + " has joined the battle!");
            currentPlayers++;
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            System.out.println(player.getName() + " has left the battle!");
            currentPlayers--;
            lock.notify(); // Уведомляем всех потоков о том, что есть место в бою
        }
    }
}

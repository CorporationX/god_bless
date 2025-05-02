package school.faang.bjs2_73524;

import lombok.Data;

@Data
public class Boss {
    private final Object lock = new Object();
    private final int maxPlayers;
    private int currentPlayers = 0;

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers == maxPlayers) {
                try {
                    System.out.printf("%s ожидает свободного слота%n", player.name());
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.printf("Thread '%s' interrupted%n", Thread.currentThread().getName());
                    Thread.currentThread().interrupt();
                }
            }
            System.out.printf("%s присоединяется к битве%n", player.name());
            currentPlayers++;
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            System.out.printf("%s покидает битву%n", player.name());
            currentPlayers--;
            lock.notifyAll();
        }
    }
}

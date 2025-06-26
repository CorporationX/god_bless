package school.faang.supercow;

import lombok.Data;

@Data
public class Boss {
    private final int maxPlayers;
    private final Object lock = new Object();
    private int currentPlayers = 0;

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                System.out.println("Нет свободных мест\n");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            player.setBattle(true);
            System.out.printf("Добавлен игрок %s, теперь игроков: %d\n", player.getName(), currentPlayers);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            if (player.isBattle()) {
                currentPlayers--;
                System.out.printf("Есть свободное место, %s покидает битву\n", player.getName());
                lock.notifyAll();
                System.out.println("Уведомили очередь\n");
                player.setBattle(false);
            }
        }
    }
}
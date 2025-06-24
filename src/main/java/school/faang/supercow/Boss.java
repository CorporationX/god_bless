package school.faang.supercow;

import lombok.Data;

@Data
public class Boss {
    private final int maxPlayer;
    private final Object lock = new Object();
    private int currentPlayers = 0;

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayer) {
                System.out.println("Нет свободных мест\n");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            System.out.printf("Добавлен игрок %s, теперь игроков: %d\n", player.name(), currentPlayers);
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.printf("Есть свободное место, %s покидает битву\n", player.name());
            lock.notifyAll();
            System.out.println("Уведомили очередь\n");
        }
    }
}
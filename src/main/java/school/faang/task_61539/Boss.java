package school.faang.task_61539;

import lombok.AllArgsConstructor;

public class Boss {
    private final int maxPlayer;
    private int currentPlayer;
    private final Object lock = new Object();

    public Boss(int maxPlayer) {
        this.maxPlayer = maxPlayer;
        this.currentPlayer = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayer >= maxPlayer) {
                try {
                    System.out.println(player.getName() + " ждет свободного слота для сражения с боссом.");
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            currentPlayer++;
            System.out.println((player.getName() + " присоединился к сражению с боссом!"));

        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayer--;
            System.out.println(player.getName() + " завершил сражение с боссом!");
            lock.notify(); // Уведомляем ожидающих игроков
        }
    }
}

package supercow;

import lombok.Data;

import java.util.concurrent.Semaphore;

@Data
public class Boss {
    private int maxPlayers;
    private Semaphore semaphore;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.semaphore = new Semaphore(maxPlayers);
    }

    public void joinBattle(Player player) {
        try {
            System.out.printf("%s ожидает свободного слота для сражения с боссом.\n", player.getName());
            semaphore.acquire();
            System.out.printf("%s присоединился к сражению с боссом.\n", player.getName());
        } catch (InterruptedException e) {
            throw new IllegalArgumentException("Ошибка при вызове метода acquire().");
        }
    }

    public void leaveBattle(Player player) {
        System.out.printf("%s завершает сражение с боссом.\n", player.getName());
        semaphore.release();
    }
}

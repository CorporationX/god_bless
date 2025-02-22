package school.faang.task_61539;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayer;
    private int currentPlayer;
    private final Object lock = new Object();

    public Boss(int maxPlayer) {
        this.maxPlayer = maxPlayer;
        this.currentPlayer = 0;
    }

    public synchronized void joinBattle(Player player) {
        while (currentPlayer >= maxPlayer) {
            try {
                log.info(player.getName() + " ждет свободного слота для сражения с боссом.");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        currentPlayer++;
        log.info((player.getName() + " присоединился к сражению с боссом!"));

    }

    public synchronized void leaveBattle(Player player) {
        currentPlayer--;
        log.info(player.getName() + " завершил сражение с боссом!");
        this.notify(); // Уведомляем ожидающих игроков
    }

}

package school.faang.BJS2_36917;

import lombok.Data;

import java.util.logging.Level;
import java.util.logging.Logger;

@Data
public class Boss {
    private final Logger logger = Logger.getLogger(Boss.class.getName());
    private int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) {
        try {
            while (maxPlayers <= currentPlayers) {
                System.out.println(player.getName() + " ожидает подключения к сессии");
                wait();
            }
        } catch (InterruptedException e) {
            logger.log(
                    Level.SEVERE,
                    "Произошла ошибка при подключении игрока " +
                            player.getName(), e);
        }
        currentPlayers++;
        System.out.println(player.getName() + " присоединятеся к сражению");
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        System.out.println(player.getName() + " покидает сессию");
        notify();
    }
}

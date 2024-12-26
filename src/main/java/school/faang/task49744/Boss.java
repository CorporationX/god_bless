package school.faang.task49744;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }


    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            log.error(" {} ждёт свободного слота для сражения с боссом  ", player.getName());
            wait();
        }
        currentPlayers++;
        log.info(" {} присоединился к сражению с боссом", player.getName());
    }

    public synchronized void leaveBattle(Player player) {
        currentPlayers--;
        log.info(" {} завершил сражение с боссом ", player.getName());
        notify();
    }
}

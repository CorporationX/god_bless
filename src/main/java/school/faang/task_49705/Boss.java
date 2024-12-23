package school.faang.task_49705;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {

    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int maxPlayers) {
        if (maxPlayers < 0) {
            throw new IllegalArgumentException("maxPlayers must be a positive integer");
        }
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public synchronized void joinBattle(Player player) throws InterruptedException {
        while (currentPlayers >= maxPlayers) {
            log.info("игрок {} ждет свободного слота для сражения с боссом.", player.getName());
            wait();
        }
        currentPlayers++;
        log.info("игрок {} присоединился к сражению с боссом!", player.getName());
    }

    public synchronized void leaveBattle(Player player) throws InterruptedException {
        currentPlayers--;
        log.info("игрок {} покинул сражение", player.getName());
        notifyAll();
    }
}
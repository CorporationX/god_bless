package school.faang.bjs2_82111;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final long id;
    private String name;
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(long id, String name, int maxPlayers) {
        this.id = id;
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.currentPlayers = 0;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("Игрок {} ждет свободное место...", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    log.info("Игрок {} был прерван по время ожидания", player.getName());
                }
            }
            currentPlayers++;
            log.info("Игрок {} присоединился к игре!", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            log.info("Игрок {} покинул игру", player.getName());
            currentPlayers--;
            lock.notify();
        }
    }
}

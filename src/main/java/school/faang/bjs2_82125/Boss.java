package school.faang.bjs2_82125;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;
    private final Object lock = new Object();

    public Boss(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    log.info("игрок {} ждет когда освободиться слот для файта", player.name());
                    lock.wait();
                } catch (InterruptedException e) {
                    log.info("поток прерван во время ожидания");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            currentPlayers++;
            log.info("игрок {} вызван в качестве помощника для битвы с консортом..", player.name());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("игрок {} ливнул курить", player.name());
            lock.notifyAll();
        }
    }
}

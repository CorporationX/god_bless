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
                    log.info("игрок {} ждет когда освободиться слот для файта", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    log.info("поток прерван во время ожидания");
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            currentPlayers++;
            log.info("игрок {} вызван в качестве помощника для битвы с консортом..", player.getName());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            log.info("игрок {} ливнул курить", player.getName());
            lock.notify();
        }
    }
}

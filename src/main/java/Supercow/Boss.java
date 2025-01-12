package Supercow;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Getter
public class Boss {
    private static final int MAX_PLAYERS = 2;
    private int currentPlayers = 0;
    private final String nameBoss;
    private final Object lock = new Object();
    private final List<Player> players = new ArrayList<>(MAX_PLAYERS);

    @SneakyThrows
    public void joinBattle(Player player) {
        synchronized (lock) {
            log.info("{} зашел ", Thread.currentThread().getName());
            while (MAX_PLAYERS <= currentPlayers) {
                log.info("{} ждет в очереди", Thread.currentThread().getName());
                lock.wait();
            }
            log.info("{} уже играет", Thread.currentThread().getName());
            players.add(player);
            currentPlayers++;
        }
        Thread.sleep(10000L);

        synchronized (lock) {
            players.remove(player);
            currentPlayers--;
            log.info("{} закончил рейд босса!", Thread.currentThread().getName());
            lock.notifyAll();
        }
    }

    public Boss(String nameBoss) {
        this.nameBoss = nameBoss;
    }
}

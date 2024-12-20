package school.faang.task_49628;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class Boss {
    private final Object lock;
    private final int maxPlayers;

    private final Set<Player> currentPlayers;

    public Boss(int maxPlayers) {
        if (maxPlayers < 0) {
            throw new IllegalArgumentException("Max players cannot be negative");
        }
        this.lock = new Object();
        this.maxPlayers = maxPlayers;
        this.currentPlayers = new HashSet<>((int) (maxPlayers / 0.75) + 1) {
        };
    }

    public void joinBattle(@NonNull Player player) {
        synchronized (lock) {
            boolean interrupted = false;
            while (currentPlayers.size() >= maxPlayers && !interrupted) {
                log.warn("{} ждет свободного слота для сражения с боссом.", player.name());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    interrupted = true;
                    log.error("Thread was interrupted", e);
                }
            }
            if (!interrupted) {
                currentPlayers.add(player);
                log.info("{} присоединился к сражению с боссом!", player.name());
            }

        }
    }

    public void leaveBattle(@NonNull Player player) {
        synchronized (lock) {
            boolean playerRemoved = currentPlayers.remove(player);
            if (playerRemoved) {
                log.info("{} завершил сражение с боссом!", player.name());
                lock.notify();
            }
        }
    }

}

package school.faang.task_49664;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@RequiredArgsConstructor
public class Boss {
    private final int maxPlayers;
    private final AtomicInteger currentPlayers = new AtomicInteger(0);

    @SneakyThrows
    public synchronized void joinBattle(Player player) {
        while (currentPlayers.get() >= maxPlayers) {
            System.out.println(player.getName() + " ждёт свободного слота для сражения с боссом.");
            wait();
        }
        currentPlayers.incrementAndGet();
        System.out.println(player.getName() + " присоединился к сражению с боссом!");
    }

    @SneakyThrows
    public synchronized void leaveBattle(Player player) {
        currentPlayers.decrementAndGet();
        System.out.println(player.getName() + " завершил сражение с боссом!");
        notify();
    }
}
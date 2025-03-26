package school.faang.task_61614;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Boss {
    private final int maxPlayers;
    private int currentPlayers = 0;
    private final Object lock = new Object();

    public void joinBattle(Player player) {
        synchronized (lock) {
            while (currentPlayers >= maxPlayers) {
                try {
                    System.out.printf("%s ждет свободный слот для сражения%n", player.getName());
                    lock.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.printf("%s был прерван во время ожидания. %s%n",
                            player.getName(), e.getMessage());
                    return;
                }
            }
            currentPlayers++;
            System.out.printf("%s вступил в бой с боссом! Кол-во свободных мест %d%n",
                    player.getName(), (maxPlayers - currentPlayers));
        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            currentPlayers--;
            System.out.printf("%s покинул сражение с боссом. Кол-во свободных мест: %d%n",
                    player.getName(), (maxPlayers - currentPlayers));
            lock.notify();
        }
    }
}

package school.faang.task_61580;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
public class Boss {
    @NonNull
    private final String name;
    private final int maxPlayers;
    private final Set<Player> currentPlayers = new HashSet<>();

    public void joinBattle(@NonNull Player player) {
        synchronized (currentPlayers) {
            String playerName = player.getName();
            if (currentPlayers.size() == maxPlayers) {
                try {
                    System.out.printf("%s ожидает свободного слота для вступления в битву%n", playerName);
                    currentPlayers.wait();
                } catch (InterruptedException e) {
                    System.out.printf("%s: ожидание свободного слота прервано%n", playerName);
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            currentPlayers.add(player);
            System.out.printf("%s вступил в битву с боссом \"%s\"%n", playerName, name);
        }
    }

    public void leaveBattle(@NonNull Player player) {
        synchronized (currentPlayers) {
            currentPlayers.remove(player);
            System.out.printf("%s завершил битву с боссом \"%s\"%n", player.getName(), name);
            currentPlayers.notify();
        }
    }
}

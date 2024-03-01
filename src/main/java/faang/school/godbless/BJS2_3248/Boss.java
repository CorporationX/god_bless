package faang.school.godbless.BJS2_3248;

import lombok.Data;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.Objects;

@Data
public class Boss {
    private final Object lock = new Object();
    @NonNull
    private Integer maxPlayers;
    private Integer currentPlayers = 0;

    @SneakyThrows
    public void joinBattle(Player player) {
        synchronized (lock) {
            if (Objects.equals(currentPlayers, maxPlayers)) {
                lock.wait();
            }
            System.out.println("Player " + player.getName() + " joins the battle");
            currentPlayers++;

        }
    }

    public void leaveBattle(Player player) {
        synchronized (lock) {
            System.out.println("Player " + player.getName() + " leaves the battle");
            currentPlayers--;
            lock.notify();
        }
    }
}

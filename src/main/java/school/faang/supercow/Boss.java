package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class Boss {
    private final int maxPlayers;
    private int currentPlayers;

    public Boss(int currentPlayers, int maxPlayers) {
        this.currentPlayers = currentPlayers;
        this.maxPlayers = maxPlayers;
    }

    public void joinBattle(Player player) throws InterruptedException {
        synchronized (this) {
            validateArgument(player);
            if ((currentPlayers + 1) > maxPlayers) {
                log.info("Нет свободного места, подождите");
                this.wait();
            }
            currentPlayers++;
            log.info("Игрок {} присоединился к сражению", player.name());
        }
    }

    public void leaveBattle(Player player) {
        synchronized (this) {
            validateArgument(player);
            currentPlayers--;
            this.notify();
            log.info("Игрок {} покинул сражение", player.name());
        }
    }

    private <T> void validateArgument(T argument) {
        Objects.requireNonNull(argument, "Переданное значение не может быть null");
    }
}